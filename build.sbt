name := "toy-component"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.0.11"


/**
  * Docker packaging
  */
enablePlugins(JavaServerAppPackaging)

/**
  * Informational Settings
  */
packageName in Docker := "toy-component"

version in Docker := "0.0.1-SNAPSHOT"

maintainer in Docker := "peter.gerhard@commercetools.de"


/**
  * Environmental Settings
  */
dockerExposedPorts := Seq(8080)

//dockerExposedVolumes := Seq(s"/etc/toy-component", s"/var/log/toy-component")

/**
  * Publishing Settings
  */
dockerRepository := Some("gcr.io/ctp-playground")

dockerUpdateLatest := true