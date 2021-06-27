package io.scalechain.crypto

import org.scalatest._
import io.scalechain.util.HexUtil._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class HashEstimationSpec extends AnyFlatSpec with BeforeAndAfterEach with Matchers {
  "getHashCalculations" should "calculate the number of hash calculations based on a hash value" in {
    HashEstimation.getHashCalculations(bytes("F000000000000000000000000000000000000000000000000000000000000000")) shouldBe 1
    HashEstimation.getHashCalculations(bytes("E000000000000000000000000000000000000000000000000000000000000000")) shouldBe 1
    HashEstimation.getHashCalculations(bytes("9000000000000000000000000000000000000000000000000000000000000000")) shouldBe 1
    HashEstimation.getHashCalculations(bytes("8000000000000000000000000000000000000000000000000000000000000000")) shouldBe 1
    HashEstimation.getHashCalculations(bytes("7000000000000000000000000000000000000000000000000000000000000000")) shouldBe 2
    HashEstimation.getHashCalculations(bytes("5000000000000000000000000000000000000000000000000000000000000000")) shouldBe 2
    HashEstimation.getHashCalculations(bytes("4000000000000000000000000000000000000000000000000000000000000000")) shouldBe 2
    HashEstimation.getHashCalculations(bytes("3000000000000000000000000000000000000000000000000000000000000000")) shouldBe 4
    HashEstimation.getHashCalculations(bytes("2000000000000000000000000000000000000000000000000000000000000000")) shouldBe 4
    HashEstimation.getHashCalculations(bytes("1000000000000000000000000000000000000000000000000000000000000000")) shouldBe 8
    HashEstimation.getHashCalculations(bytes("0F00000000000000000000000000000000000000000000000000000000000000")) shouldBe 16
    HashEstimation.getHashCalculations(bytes("0E00000000000000000000000000000000000000000000000000000000000000")) shouldBe 16
    HashEstimation.getHashCalculations(bytes("0900000000000000000000000000000000000000000000000000000000000000")) shouldBe 16
    HashEstimation.getHashCalculations(bytes("0800000000000000000000000000000000000000000000000000000000000000")) shouldBe 16
    HashEstimation.getHashCalculations(bytes("0700000000000000000000000000000000000000000000000000000000000000")) shouldBe 32
  }
}