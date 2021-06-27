package io.scalechain.blockchain.api.domain

import org.scalatest._
import spray.json.DefaultJsonProtocol.StringJsonFormat
import spray.json._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/**
  * Test cases for validating our assumptions on spray.io
  */
class SprayIoSpec extends AnyFlatSpec with BeforeAndAfterEach with Matchers {
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

  implicit object JsValueFormat extends RootJsonFormat[JsValue] {
    def write(any: JsValue) = {
      // Not used.
      assert(false);
      "".toJson
    }

    def read(value: JsValue): JsValue =
      value
  }

  "convertTo" should "be able to leave JsValue as is if we want" in {
    val jsStr = JsString("abc")
    jsStr.convertTo[JsValue] shouldBe jsStr
  }
}
