package io.scalechain.wallet

import io.scalechain.blockchain.proto.{Hash, Transaction, WalletTransaction, WalletOutput}
import io.scalechain.blockchain.script.HashSupported._
import io.scalechain.blockchain.transaction.{OutputOwnership, TransactionTestDataTrait}
import org.scalatest.matchers.should.Matchers

/**
  * Created by kangmo on 5/18/16.
  */
trait WalletStoreTestDataTrait extends TransactionTestDataTrait with Matchers {
  val ACCOUNT1 = "acc1"
  val ACCOUNT2 = "acc2"
  val ACCOUNT3 = "acc3"

  def generateWalletOutput(transaction : Transaction) : WalletOutput = {
    WalletOutput(
      blockindex    = Some(100L),
      coinbase      = true,
      spent         = false,
      transactionOutput = transaction.outputs(0)
    )
  }

  def generateWalletTransaction(transaction : Transaction) : WalletTransaction = {
    WalletTransaction(
      blockHash        = Some(Hash("00000000bd0ed80435fc9fe3269da69bb0730ebb454d0a29128a870ea1a37929")),
      blockIndex       = Some(11),
      blockTime        = Some(1411051649),
      transactionId    = Some(transaction.hash),
      addedTime     = 1418695703,
      transactionIndex = Some(1),
      transaction = transaction
    )
  }

  def checkElementEquality(actualOwnerships : List[OutputOwnership], expectedOwnerships : Set[OutputOwnership] )  {
//    scrubScript( actualOwnerships.toList.sortBy(_.stringKey()) ) shouldBe expectedOwnerships.sortBy(_.stringKey())
      scrubScript( actualOwnerships ).toSet  shouldBe expectedOwnerships
  }

  val WALLET_OUTPUT1 = generateWalletOutput(transaction1)
  val WALLET_OUTPUT2 = generateWalletOutput(transaction2)
  val WALLET_OUTPUT3 = generateWalletOutput(transaction3)

  val WALLET_TX1 = generateWalletTransaction(transaction1)
  val WALLET_TX2 = generateWalletTransaction(transaction2)
  val WALLET_TX3 = generateWalletTransaction(transaction3)

}
