package io.scalechain.blockchain.transaction

import io.scalechain.blockchain.proto.codec.BlockCodec
import io.scalechain.blockchain.proto.{ Block, Hash }
import io.scalechain.util.HexUtil._

/**
  * ChainEnvironment, which hash a list of configuration values for an environment.
  */
trait ChainEnvironment {

  /** The genesis block.
    */
  val GenesisBlock: Block

  /** The hash of the genesis block.
    */
  val GenesisBlockHash: Hash

  /** The default port number for the peer to peer communication.
    */
  val DefaultPort: Int

  /** The version prefix of an address using PubKeyHash.
    */
  val PubkeyAddressVersion: Byte

  /** The version prefix of an address using P2SH.
    */
  val ScriptAddressVersion: Byte

  /** The version prefix of a private key.
    */
  val SecretKeyVersion: Byte

  /** The magic value used by messages for the peer to peer communication and the block data file.
    */
  val MagicValue: Array[Byte]

  /** The default transaction version
    */
  val DefaultTransactionVersion: Int

  /** The default block version
    */
  val DefaultBlockVersion: Int

  /** Outputs of coinbase transactions can be spent after CoinbaseMaturity confirmations.
    */
  val CoinbaseMaturity: Int
}

/** The mainnet environment.
  */
object MainNetEnvironment extends ChainEnvironment {
  private val SERIALIZED_GENESIS_BLOCK =
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
  val GenesisBlock     = BlockCodec.parse(SERIALIZED_GENESIS_BLOCK)
  val GenesisBlockHash = Hash(bytes("000000000019d6689c085ae165831e934ff763ae46a2a6c172b3f1b60a8ce26f"))

  val DefaultPort = 8333

  val PubkeyAddressVersion = 0.toByte
  val ScriptAddressVersion = 5.toByte
  val SecretKeyVersion     = 128.toByte

  val MagicValue = bytes("D9B4BEF9")

  /** The default transaction version
    */
  val DefaultTransactionVersion: Int = 4

  /** The default block version
    */
  val DefaultBlockVersion: Int = 1

  /** Outputs of coinbase transactions can be spent after CoinbaseMaturity confirmations.
    */
  val CoinbaseMaturity: Int = 100
}

/** The class that has environment values for the testnet and regtest.
  */
class TestEnvironment extends ChainEnvironment {
  private val SERIALIZED_GENESIS_BLOCK =
    bytes("""
        |01 00 00 00 00 00 00 00
        |00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00
        |00 00 00 00 00 00 00 00 00 00 00 00 3b a3 ed fd
        |7a 7b 12 b2 7a c7 2c 3e 67 76 8f 61 7f c8 1b c3
        |88 8a 51 32 3a 9f b8 aa 4b 1e 5e 4a da e5 49 4d
        |ff ff 00 1d 1a a4 ae 18 01 01 00 00 00 01 00 00
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

  val GenesisBlock     = BlockCodec.parse(SERIALIZED_GENESIS_BLOCK)
  val GenesisBlockHash = Hash(bytes("000000000933ea01ad0ee984209779baaec3ced90fa3f408719526f8d77f4943"))

  val DefaultPort = 18333

  val PubkeyAddressVersion = 111.toByte
  val ScriptAddressVersion = 196.toByte
  val SecretKeyVersion     = 239.toByte

  val MagicValue = bytes("0709110B")

  /** The default transaction version
    */
  val DefaultTransactionVersion: Int = 4

  /** The default block version
    */
  val DefaultBlockVersion: Int = 1

  /** Outputs of coinbase transactions can be spent after CoinbaseMaturity confirmations.
    */
  val CoinbaseMaturity: Int = 2
}

/** The singleton for the testnet environment.
  */
object TestNetEnvironment extends TestEnvironment {}

/** The singleton for the regtest environment.
  */
object RegTestEnvironment extends TestEnvironment {}

/** The chain environment factory which returns an environment based on an environment name.
  */
object ChainEnvironment {

  /** The map from an environment name to an environment object.
    */
  val EnvironmentByName = Map(
    "mainnet" -> MainNetEnvironment,
    "testnet" -> TestNetEnvironment,
    "regtest" -> RegTestEnvironment
  )

  /** The current environment.
    */
  protected[transaction] var activeEnvironmentOption: Option[ChainEnvironment] = None

  /** Create an environment object based on the given environment name.
    *
    * @param environmentName The name of the environment.
    * @return The environment object.
    */
  def create(environmentName: String): Option[ChainEnvironment] = {
    activeEnvironmentOption = EnvironmentByName.get(environmentName)
    activeEnvironmentOption
  }

  /** Get the active chain environment.
    *
    * @return Some(env) if any chain environment is active. None otherwise.
    */
  def get(): ChainEnvironment =
    activeEnvironmentOption.get
}

/** The chain test trait to be mixed into test cases that needs to use the chain environment.
  */
trait ChainTestTrait {
  val env = ChainEnvironment.create("testnet").get
}
