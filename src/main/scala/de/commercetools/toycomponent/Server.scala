package de.commercetools.toycomponent

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

object Server extends App {

  implicit val actorSystem: ActorSystem = ActorSystem("Hello World")
  implicit val actorMaterializer: ActorMaterializer = ActorMaterializer()

  val route =
    pathSingleSlash {
      get {
        complete {
          "Hello world"
        }
      }
    }

  Http().bindAndHandle(route,"localhost",8080)
}
