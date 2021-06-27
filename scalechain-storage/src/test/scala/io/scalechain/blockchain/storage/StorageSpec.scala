package io.scalechain.blockchain.storage

import org.scalatest._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/**
  * Created by kangmo on 11/2/15.
  */
class StorageSpec extends AnyFlatSpec with BeforeAndAfterEach with Matchers {

  override def beforeEach() {
    super.beforeEach()
  }

  override def afterEach() {
    super.afterEach()

  }

  "initialized" should "return true after initialize is invoked" in {
    Storage.initialize()
    Storage.initialized() shouldBe true
  }
}
