package io.scalechain.blockchain.net.message

import io.scalechain.blockchain.proto.{ GetData, Hash, InvVector }

/**
  *  The factory that creates GetData messages.
  */
object GetDataFactory {
  def create(inventories: List[InvVector]): GetData =
    GetData(inventories)
}
