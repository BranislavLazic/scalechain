package io.scalechain.blockchain.net.message

import io.scalechain.blockchain.proto.{ BlockHeader, Hash, Headers, Inv }

/**
  *  The factory that creates Headers messages.
  */
object HeadersFactory {
  def create(blockHeaders: List[BlockHeader]): Headers =
    Headers(blockHeaders)
}
