package io.scalechain.blockchain.chain

import io.scalechain.blockchain.transaction.TransactionTestDataTrait
import org.scalatest._
import org.scalatest.matchers.should.Matchers
import org.scalatest.flatspec.AnyFlatSpec

class TransactionAnalyzerSpec extends AnyFlatSpec with BeforeAndAfterEach with TransactionTestDataTrait with Matchers {
  "sumAmount" should "should sum the amount of transaction outputs" in {
    TransactionAnalyzer.sumAmount(List(OUTPUT1, OUTPUT2, OUTPUT3)) shouldBe (OUTPUT1.value + OUTPUT2.value + OUTPUT3.value)
  }

  "calculateFee" should "" ignore {
    // TODO : Implement
  }

  "getSpentOutputs" should "" ignore {
    // TODO : Implement
  }
}