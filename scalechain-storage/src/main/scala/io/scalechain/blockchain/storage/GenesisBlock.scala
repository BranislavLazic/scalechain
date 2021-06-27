package io.scalechain.blockchain.storage

import io.scalechain.blockchain.proto.Hash
import io.scalechain.blockchain.proto.codec.BlockCodec
import io.scalechain.util.HexUtil._

/**
  * Created by kangmo on 3/16/16.
  */
object GenesisBlock {
  val SERIALIZED_GENESIS_BLOCK =
    bytes("""
        |01 00 00 00 00 00 00 00
        |00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00
        |00 00 00 00 00 00 00 00 00 00 00 00 3b a3 ed fd
        |7a 7b 12 b2 7a c7 2c 3e 67 76 8f 61 7f c8 1b c3
        |88 8a 51 32 3a 9f b8 aa 4b 1e 5e 4a 29 ab 5f 49
        |ff ff 00 1d 1d ac 2b 7c 01 01 00 00 00 01 00 00
        |00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00
        |00 00 00 00 00 00 00 00 00 00 00 00 00 00 ff ff
        |ff ff 4d 04 ff ff 00 1d 01 04 45 54 68 65 20 54
        |69 6d 65 73 20 30 33 2f 4a 61 6e 2f 32 30 30 39
        |20 43 68 61 6e 63 65 6c 6c 6f 72 20 6f 6e 20 62
        |72 69 6e 6b 20 6f 66 20 73 65 63 6f 6e 64 20 62
        |61 69 6c 6f 75 74 20 66 6f 72 20 62 61 6e 6b 73
        |ff ff ff ff 01 00 f2 05 2a 01 00 00 00 43 41 04
        |67 8a fd b0 fe 55 48 27 19 67 f1 a6 71 30 b7 10
        |5c d6 a8 28 e0 39 09 a6 79 62 e0 ea 1f 61 de b6
        |49 f6 bc 3f 4c ef 38 c4 f3 55 04 e5 1e c1 12 de
        |5c 38 4d f7 ba 0b 8d 57 8a 4c 70 2b 6b f1 1d 5f
        |ac 00 00 00 00
      """.stripMargin)

  val BLOCK = BlockCodec.parse(SERIALIZED_GENESIS_BLOCK)
  val HASH  = Hash(bytes("000000000019d6689c085ae165831e934ff763ae46a2a6c172b3f1b60a8ce26f"))
}
