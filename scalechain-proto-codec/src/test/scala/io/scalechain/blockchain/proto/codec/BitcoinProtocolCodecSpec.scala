package io.scalechain.blockchain.proto.codec


import org.scalatest._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
/**
  * Created by kangmo on 11/2/15.
  */
class BitcoinProtocolCodecSpec extends AnyFlatSpec with BeforeAndAfterEach with Matchers {
  this: Suite =>

  override def beforeEach() {
    // set-up code
    //

    super.beforeEach()
  }

  override def afterEach() {
    super.afterEach()
    // tear-down code
    //
  }

  "encode" should "successfully encode a message" in {
  }

  "decode" should "return an incomplete message with an empty message vector" in {
  }

  "decode" should "return an incomplete message with a non-empty message vector" in {
  }

  "decode" should "return no incomplete message with a non-empty message vector" in {
  }
}
