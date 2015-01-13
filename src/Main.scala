package com.hamrah.streamsplayground

import akka.stream.FlowMaterializer
import akka.actor.ActorSystem
import akka.stream.scaladsl._

object Main extends App {
  implicit val system = ActorSystem("flow-playground")

  implicit val flowMaterializer = FlowMaterializer()
  RabbitMqConsumer.consume().runWith(Sink.ignore)
}
