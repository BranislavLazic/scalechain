package io.scalechain.blockchain.net.handler

import java.io.File

import io.netty.channel.embedded.EmbeddedChannel
import org.scalatest._
import org.scalatest.matchers.should.Matchers

class VersionMessageHandlerSpec extends MessageHandlerTestTrait with Matchers {
  this: Suite =>

  val testPath = new File("./target/unittests-VersionMessageHandlerSpec/")

  "handle" should "" in {}
}
