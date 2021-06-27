package io.scalechain.blockchain.proto

import io.scalechain.util.{ ByteArray, HexUtil }

/**
  * All cases classes related to private blockchain are defined here.
  */

case class BlockConsensus(header: BlockHeader, height: Long) extends ProtocolMessage
