package com.hamrah.streamsplayground

import akka.stream.FlowMaterializer
import akka.actor.{ ActorSystem, Props }
import akka.stream.scaladsl._

object Main extends App {
  implicit val system = ActorSystem("flow-playground")

  system.actorOf(Props(classOf[HttpService]), "http-server")

}
