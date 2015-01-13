package com.hamrah.streamsplayground

import akka.stream.FlowMaterializer
import akka.actor.ActorSystem

object Main extends App {
  implicit val system = ActorSystem("flow-playground")

  implicit val flowMaterializer = FlowMaterializer()
  RabbitMqConsumer.consume//(flowMaterializer)
}
