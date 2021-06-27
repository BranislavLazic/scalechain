package io.scalechain.blockchain.chain
import io.scalechain.blockchain.proto
import io.scalechain.blockchain.proto.{ Block, BlockHeader, Hash, Transaction }
import io.scalechain.blockchain.transaction.ChainEnvironment

import scala.collection.mutable.ListBuffer

object BlockBuilder {
  def newBuilder() = new BlockBuilder
}

/**
  * Builds a block with a list of transactions.
  */
class BlockBuilder {

  /** A list buffer that has transactions for this block.
    */
  val transactionsBuffer = new ListBuffer[Transaction]()

  /** Add a transaction.
    *
    * @param transaction the transaction to add.
    */
  def addTransaction(transaction: Transaction): BlockBuilder = {
    transactionsBuffer.append(transaction)
    this
  }

  /** Check if the current status of the builder is valid.
    *
    * 1. Check the size of serialized block.
    *
    * @param block The block to use to calculate the serialized size of it.
    */
  protected[chain] def checkValidity(block: Block): Unit = {
    // TODO : Implement it.
  }

  /** Get the block.
    *
    * @param hashPrevBlock The hash of the previous block header.
    * @param timestamp The block timestamp.
    * @param version The version of the block
    * @param target The target difficulty
    * @param nonce The nonce value.
    * @return The built block.
    */
  def build(
      hashPrevBlock: Hash,
      timestamp: Long,
      version: Int = ChainEnvironment.get.DefaultBlockVersion,
      target: Long = 0, /* TODO : Set The default target */
      nonce: Long = 0
  ): Block = {
    val transactions   = transactionsBuffer.toList
    val merkleRootHash = MerkleRootCalculator.calculate(transactions)
    val blockHeader    = BlockHeader(version, hashPrevBlock, merkleRootHash, timestamp, target, nonce)
    val block = Block(
      blockHeader,
      transactions
    )
    block
  }
}
