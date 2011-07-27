/*
 * Copyright 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.jribble

import org.junit.Test
import org.junit.Assert._
import java.util.jar._
import java.io.{Reader, InputStreamReader, InputStream, ByteArrayInputStream}
import com.google.jribble.ast.{JribbleProtos, JribbleProtoWriter, JribbleProtoReader}
import com.google.protobuf.{ExtensionRegistry, CodedInputStream}

class ParseScalaLibraryJribble {
  val defParser = new DefParser with CachingDefParser

  @Test
  def tryToParseAllFiles {
    val time1 = System.currentTimeMillis
    val parsed = mapJribbleFiles((s, in ) => defParser.parse(in, s)).toList
    val successful = (parsed collect { case (name, Left(node)) => (name, node) }).toList
    val failed = (parsed collect { case (name, Right(msg)) => (name, msg) }).toList
    val time2 = System.currentTimeMillis
    if (failed.isEmpty)
      println("Parsed all files successfully!")
    else {
      println("Failed to parse %1s jribble files.".format(failed.size))
      failed foreach { case (name, msg) =>
        println("Failed to parse %1s:\n%2s".format(name, msg))
      }
    }
    println("Parsing took %1d milis".format(time2-time1))
    val time3 = System.currentTimeMillis
    for((name, node) <- successful) {
      val message = JribbleProtoWriter.convertDeclaredTypeToMessage(node)
      val inputStream = CodedInputStream.newInstance(new ByteArrayInputStream(message.toByteArray()))
      inputStream.setRecursionLimit(Integer.MAX_VALUE)
      val newMessage = JribbleProtos.DeclaredType.parseFrom(inputStream);
      assertEquals(message, newMessage);
      val newNode = JribbleProtoReader.readDeclaredTypeMessage(message)
      assertEquals("Unable to serialize/deserialize file '" + name + "'", node, newNode);
    }
    println("protobuff serialization/deserialization took %1d milis".format(System.currentTimeMillis-time3))
    assertTrue("Failed to parse all jribble files.".format(failed.size), failed.isEmpty)
  }

  private def mapJribbleFiles[T](f: (String, java.io.Reader) => T): Iterator[(String, T)] = {
    val jarFile = scalaLibraryJribbleJar
    println("Trying to parse jribble files from %1s".format(jarFile.getName))
    val jribbleFiles: List[JarEntry] = (new Iterator[JarEntry] {
      val enum = jarFile.entries
      def hasNext = enum.hasMoreElements
      def next = enum.nextElement
    } filter (_.getName endsWith ".jribble")).toList//.filter (_.getName == "scala/Array$.jribble")
    println("Found %1d jribble files.".format(jribbleFiles.size))
    jribbleFiles.toIterator map { jarEntry =>
      val reader = new ResettableInputStreamReader(jarFile.getInputStream(jarEntry))
      val name = jarEntry.getName
      val result = f(name, reader)
      reader.close()
      (name, result)
    }
  }

  lazy val scalaLibraryJribbleJar: JarFile = {
    val scalaLibraryJribbleName = "scala-library-jribble.jar"
    val userDirectory = System.getProperty("user.dir")
    import java.io.File
    val file = new File(new File(userDirectory, "lib_test"), scalaLibraryJribbleName)
    new JarFile(file)
  }

  /**
   * Reader that reads characters from InputStream and can be resetted by
   * re-evaluating InputStream parameter.
   */
  private final class ResettableInputStreamReader(in: => InputStream) extends Reader {
    private var reader: Reader = _
    reset()
    override def reset() = {
      reader = new InputStreamReader(in)
    }
    def close() = reader.close()
    def read(cbuf: Array[Char], off: Int, len: Int) = reader.read(cbuf, off, len)
  }
}
