import Dependencies._
import sbt._

sbtVersion := "1.9.2"

updateOptions := updateOptions.value.withCachedResolution(false)

assembly / assemblyMergeStrategy := {
 case PathList("META-INF", _*) => MergeStrategy.discard
 case _                        => MergeStrategy.first
}

lazy val root = (project in file("."))
  .settings(
    name := "RosbagInputFormat",
    version := "0.9.9",
    scalaVersion := "2.12.14",
    organization := "org.apache.spark.version",
    libraryDependencies ++= Seq(
      "com.google.code.gson" % "gson" % "2.8.0",
      "org.apache.spark" %% "spark-core" % "3.0.1",
      "com.google.protobuf" % "protobuf-java" % "3.3.0"
    ),
    Compile / packageBin / packageOptions += 
      Package.ManifestAttributes(
        "Class-Path" -> Seq(".","scala-library-2.12.14.jar","protobuf-java-3.3.0.jar").mkString(" ")),
  )
