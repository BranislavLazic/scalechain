package io.scalechain.blockchain.net.handler

import java.io.File

import io.netty.channel.embedded.EmbeddedChannel
import org.scalatest._
import org.scalatest.matchers.should.Matchers

class PongMessageHandlerSpec extends MessageHandlerTestTrait with Matchers {
  this: Suite =>

  val testPath = new File("./target/unittests-PongMessageHandlerSpec/")

  "handle" should "" in {}
}
