package com.hamrah.streamsplayground

import com.typesafe.config.ConfigFactory

object Config {
  private val config = ConfigFactory.load()
  lazy val streams = config.getConfig("streams-playground")

  lazy val interface = streams.getString("interface")
  lazy val port = streams.getInt("port")
}
