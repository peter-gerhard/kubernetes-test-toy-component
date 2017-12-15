package de.commercetools.toycomponent

import fs2.Task
import org.http4s.server.blaze.BlazeBuilder
import org.http4s.util.StreamApp

import scala.util.Properties.envOrNone

object Server extends StreamApp {
  val port: Int = envOrNone("HTTP_PORT").fold(8080)(_.toInt)

  def stream(args: List[String]): fs2.Stream[Task, Nothing] = BlazeBuilder.bindHttp(port)
    .mountService(HelloWorld.service, "/")
    .serve
}
