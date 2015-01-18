package com.hamrah.streamsplayground

import akka.actor._
import akka.http._
import akka.http.server._
import akka.stream.scaladsl._
import de.heikoseeberger.akkasse.{ Sse, SseMarshalling }
import scala.language.implicitConversions

class HttpService
  extends Actor
  with Directives
  with ImplicitFlowMaterializer
  with SseMarshalling {

    import context.dispatcher

    override def receive: Receive = Actor.emptyBehavior

    Http()(context.system)
      .bind(Config.interface, Config.port)
      .startHandlingWith(route)

    implicit def stringToSseMessage(event: String): Sse.Message = {
      Sse.Message(event, Some("published"))
    }
    private def route: Route = sse ~ assets

    private def assets: Route =
      path("") {
        getFromResource("assets/index.html")
      } ~ getFromResourceDirectory("assets")

    private def sse: Route = {
      path("messages") {
        get {
          complete {
            RabbitMqConsumer.consume
          }
        }
      }
    }

}
