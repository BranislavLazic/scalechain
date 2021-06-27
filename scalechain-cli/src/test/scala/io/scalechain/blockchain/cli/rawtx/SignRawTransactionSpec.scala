package io.scalechain.blockchain.cli.rawtx

import io.scalechain.blockchain.api.command.rawtx.SignRawTransaction
import io.scalechain.blockchain.api.domain.RpcError
import io.scalechain.blockchain.cli.APITestSuite
import org.scalatest._
import org.scalatest.flatspec.AnyFlatSpec

/**
  * Created by kangmo on 11/2/15.
  */
// The test does not pass yet. Will make it pass soon.
@Ignore
class SignRawTransactionSpec extends AnyFlatSpec with BeforeAndAfterEach with APITestSuite {
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

  // The test does not pass yet. Will make it pass soon.
  "SignRawTransaction" should "" in {
    // TODO : Implement.
  }

  "SignRawTransaction" should "return an error if no parameter was specified." in {
    val response = invoke(SignRawTransaction)
    val result   = response.left.get
    result.code shouldBe RpcError.RPC_INVALID_REQUEST.code
  }
}
