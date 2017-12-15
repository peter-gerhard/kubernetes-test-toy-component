import com.typesafe.sbt.packager.docker.DockerVersion

name := "toy-component"

version := "0.1"

scalaVersion := "2.12.4"

val Http4sVersion = "0.17.5"
val Specs2Version = "4.0.0"
val LogbackVersion = "1.2.3"

libraryDependencies ++= Seq(
  "org.http4s"     %% "http4s-blaze-server"  % Http4sVersion,
  "org.http4s"     %% "http4s-circe"         % Http4sVersion,
  "org.http4s"     %% "http4s-dsl"           % Http4sVersion,
  "org.specs2"     %% "specs2-core"          % Specs2Version % "test",
  "ch.qos.logback" %  "logback-classic"      % LogbackVersion
)


// Docker packaging
enablePlugins(JavaServerAppPackaging)

packageName in Docker := "toy-component"

version in Docker := "0.0.1-SNAPSHOT"

maintainer in Docker := "peter.gerhard@commercetools.de"

//dockerExposedPorts := Seq(8080)

dockerVersion := DockerVersion.parse("17.09.1")

//dockerExposedVolumes in Docker = ""
