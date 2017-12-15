package de.commercetools.toycomponent

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

object Server extends App {

  implicit val actorSystem: ActorSystem = ActorSystem("HelloWorld")
  implicit val actorMaterializer: ActorMaterializer = ActorMaterializer()

  val route =
    pathSingleSlash {
      get {
        complete {
          "Hello world"
        }
      }
    }

  val port = 8080
  println(s"Binding server to port $port")
  Http().bindAndHandle(route, "localhost", port)
}
