package io.scalechain.blockchain.storage

import org.scalatest._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/**
  * Created by kangmo on 11/2/15.
  */
class BlockIndexSpec extends AnyFlatSpec with BeforeAndAfterEach with Matchers {
  this: Suite =>

  Storage.initialize()

  override def beforeEach() {
    super.beforeEach()
  }

  override def afterEach() {
    super.afterEach()

  }

  // BlockIndex is a trait. No need to create test cases for a trait.
}

