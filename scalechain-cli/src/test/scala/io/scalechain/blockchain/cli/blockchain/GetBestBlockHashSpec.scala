package io.scalechain.blockchain.cli.blockchain

import io.scalechain.blockchain.api.command.blockchain.GetBestBlockHash
import io.scalechain.blockchain.api.domain.StringResult
import io.scalechain.blockchain.cli.APITestSuite
import org.scalatest._
import org.scalatest.flatspec.AnyFlatSpec

/**
  * Created by kangmo on 11/2/15.
  */
// The test does not pass yet. Will make it pass soon.
@Ignore
class GetBestBlockHashSpec extends AnyFlatSpec with BeforeAndAfterEach with APITestSuite {
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

  "GetBestBlockHash" should "return the best block hash" in {
    val result = invoke(GetBestBlockHash)
    result.right.get.get.asInstanceOf[StringResult].value.length shouldBe 64
  }
}
