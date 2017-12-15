//import com.typesafe.sbt.packager.docker.DockerVersion

name := "toy-component"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.0.11"


// Docker packaging
enablePlugins(JavaServerAppPackaging)

packageName in Docker := "toy-component"

version in Docker := "0.0.1-SNAPSHOT"

maintainer in Docker := "peter.gerhard@commercetools.de"

//dockerExposedPorts := Seq(8080)

//dockerVersion := DockerVersion.parse("17.09.1")

//dockerExposedVolumes in Docker = ""
