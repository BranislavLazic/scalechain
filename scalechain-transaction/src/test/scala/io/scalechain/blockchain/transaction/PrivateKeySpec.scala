package io.scalechain.blockchain.transaction

import org.scalatest._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PrivateKeySpec extends AnyFlatSpec with BeforeAndAfterEach with ChainTestTrait with Matchers {
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

  "PrivateKey.from" should "create a private key from wallet import format generated by base58 method" in {
    // PrivateKey.generate and base58 method are tested here.
    for ( i <- 1 to 100) { // test many times to make sure different kinds of randomly generated private keys work well.
      val originalPrivateKey = PrivateKey.generate()
      val expectedPrivateKey = originalPrivateKey.base58()
      val decodedPrivateKey = PrivateKey.from(expectedPrivateKey)
      val actualPrivateKey = decodedPrivateKey.base58

      originalPrivateKey shouldBe decodedPrivateKey
      actualPrivateKey shouldBe expectedPrivateKey
    }
  }
}