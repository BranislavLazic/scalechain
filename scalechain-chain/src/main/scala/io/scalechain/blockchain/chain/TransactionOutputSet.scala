package io.scalechain.blockchain.chain

import io.scalechain.blockchain.storage.index.KeyValueDatabase
import io.scalechain.blockchain.transaction.CoinsView
import io.scalechain.blockchain.{ ChainException, ErrorCode }
import io.scalechain.blockchain.proto.{ OutPoint, TransactionOutput }
import org.eclipse.collections.impl.map.mutable.ConcurrentHashMap

import scala.collection.mutable

/** Keeps a set of transaction outputs.
  *
  * TODO : Add test cases.
  */
class TransactionOutputSet extends CoinsView {

  /** The map from an out point to a transaction output.
    */
  val outputsByOutPoint = new ConcurrentHashMap[OutPoint, TransactionOutput]()

  /** The map from a transaction output to an out point
    */
  val outPointsByOutput = new ConcurrentHashMap[TransactionOutput, OutPoint]()

  /** Add a coin to the set.
    *
    * @param outPoint The out point that points to the output.
    * @param transactionOutput The transaction output to put.
    */
  def addTransactionOutput(outPoint: OutPoint, transactionOutput: TransactionOutput): Unit = {
    outputsByOutPoint.put(outPoint, transactionOutput)
    outPointsByOutput.put(transactionOutput, outPoint)
  }

  /**
    * Get the out point by searching with the transaction output.
    *
    * @param transactionOutput The transaction output to search.
    * @return The found output.
    */
  def getOutPoint(transactionOutput: TransactionOutput): Option[OutPoint] = {
    val output = outPointsByOutput.get(transactionOutput)
    if (output == null) None else Some(output)
  }

  /** Get a transaction output by searching with a given out point.
    *
    * @param outPoint The outpoint that points to the transaction output.
    * @return The transaction output we found.
    */
  def getTransactionOutput(outPoint: OutPoint)(implicit db: KeyValueDatabase): TransactionOutput = {
    val output = outputsByOutPoint.get(outPoint)
    if (output == null)
      throw new ChainException(ErrorCode.InvalidTransactionOutPoint)
    output
  }
}
