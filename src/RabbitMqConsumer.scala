package com.hamrah.streamsplayground

import akka.stream._
import scaladsl._
import io.scalac.amqp._

object RabbitMqConsumer {
  val connection = Connection()

  def consume() = {
    Source(connection.consume("streams-playground"))
      .map(_.message.body.utf8String)
      .map(println(_))
  }
}
