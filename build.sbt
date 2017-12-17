import com.typesafe.sbt.packager.docker.DockerVersion

name := "toy-component"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.0.11"


// Docker packaging
enablePlugins(JavaServerAppPackaging)

packageName in Docker := "toy-component"

version in Docker := "0.0.1-SNAPSHOT"

maintainer in Docker := "peter.gerhard@commercetools.de"

dockerExposedPorts := Seq(8080)

dockerExposedVolumes := Seq(s"/etc/toy-component", s"/var/log/toy-component")

dockerVersion := DockerVersion.parse("17.09.1")

bashScriptExtraDefines ++= Seq(
  """addJava "-Xms1024m"""",
  """addJava "-Xmx1024m""""
)