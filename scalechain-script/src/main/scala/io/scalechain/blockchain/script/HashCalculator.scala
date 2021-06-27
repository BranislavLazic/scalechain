package io.scalechain.blockchain.script

import io.scalechain.blockchain.proto.{ Block, BlockHeader, Hash, Transaction }
import io.scalechain.blockchain.proto.codec.{ BlockCodec, BlockHeaderCodec, TransactionCodec }

protected[script] object HashCalculator {
  def transactionHash(transaction: Transaction): Hash = {
    val serializedBytes = TransactionCodec.serialize(transaction)

    // Run SHA256 twice and reverse bytes.
    val hash = io.scalechain.crypto.HashFunctions.hash256(serializedBytes)

    Hash(hash.value.reverse)
  }

  def blockHeaderHash(blockheader: BlockHeader): Hash = {
    val serializedBlockHeader = BlockHeaderCodec.serialize(blockheader)

    // Run SHA256 twice and reverse bytes.
    val blockHeaderHash = io.scalechain.crypto.HashFunctions.hash256(serializedBlockHeader)

    Hash(blockHeaderHash.value.reverse)
  }
}

object HashSupported {
  implicit def toHashSupportedBlockHeader(blockHeader: BlockHeader) = HashSupportedBlockHeader(blockHeader)
  implicit def toHashSupportedTransaction(transaction: Transaction) = HashSupportedTransaction(transaction)
}

case class HashSupportedTransaction(transaction: Transaction) {
  def hash() =
    HashCalculator.transactionHash(transaction)
}

case class HashSupportedBlockHeader(blockHeader: BlockHeader) {
  def hash() =
    HashCalculator.blockHeaderHash(blockHeader)
}
