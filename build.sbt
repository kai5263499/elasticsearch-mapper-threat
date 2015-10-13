// build.sbt
import sbtassembly.Plugin.AssemblyKeys._
 
name := "ScalaElasticSearchPlugin"
 
version := "1.0"
 
scalaVersion := "2.10.2"
 
libraryDependencies += "org.elasticsearch" % "elasticsearch" % "0.90.10" % "provided"
 
assemblySettings
 
assembly <<= assembly map { (f: File) =>
  val zipPath = f.getPath.substring(0, f.getPath.length - f.ext.length - 1) + ".zip"
  val zipFile = file(zipPath)
  IO.zip(List((f, f.toPath.getFileName.toString)), zipFile)
  println("GENERATED PACKAGE LOCATION:  " + zipPath)
  zipFile
}