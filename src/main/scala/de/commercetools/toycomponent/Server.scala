package de.commercetools.toycomponent

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

object Server extends App {
    implicit val actorSystem: ActorSystem = ActorSystem("HelloWorld")
    implicit val actorMaterializer: ActorMaterializer = ActorMaterializer()

    val route =
      path(Remaining) { _ ⇒
        get {
          complete {
            "Hello world"
          }
        }
      }

    Http().bindAndHandle(route, "0.0.0.0", 8080)
}
