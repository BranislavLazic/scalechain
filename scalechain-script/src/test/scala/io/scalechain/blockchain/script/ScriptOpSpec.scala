package io.scalechain.blockchain.script

import org.scalatest._
import org.scalatest.flatspec.AnyFlatSpec

/** Test common super classes of script operations in ScriptOp.scala
  *
  */
class ScriptOpSpec extends AnyFlatSpec with BeforeAndAfterEach with OperationTestTrait {

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

  "method" should "do something" in {
  }
}
