package io.scalechain.blockchain.proto.test

import io.scalechain.blockchain.proto._
import io.scalechain.util.HexUtil._

/**
  * Created by kangmo on 5/15/16.
  */
trait ProtoTestData {
  val ALL_ZERO_HASH = Hash(bytes("0" * 64))

  val transaction1 = Transaction(
    version = 1,
    inputs = List(
      NormalTransactionInput(
        outputTransactionHash = Hash(bytes("42828762f3233f5b4ca6d56dc8b90c7e7fd27c971860c6df7b628c6090212553")),
        outputIndex = 1,
        unlockingScript = UnlockingScript(
          bytes(
            "483045022100e55e797b51711148692b9cc4a2c80652c69bd78d4103438dec41e01670c046f802207ef80574570cfde8f6a788a6b2900343d01115645b6a037773c43df507493294012102772555483a3445bab2cdd3886a1cc9b362f4e9991db50d0944689aed90b67b19"
          )
        ),
        sequenceNumber = 4294967295L
      ),
      NormalTransactionInput(
        outputTransactionHash = Hash(bytes("b4055f82e6607c370e20f58245fb2ff304989d817b565dfa131b774176cacdb3")),
        outputIndex = 1,
        unlockingScript = UnlockingScript(
          bytes(
            "483045022100844f55bdc9bfa12f468560ee293219433ad96060538a6ee6df7d0922d7e4b80602204da8d73e024e353fb5598dda67a6afe8425677b7ee483cbb2147ced5bfc5a629012103df96db891b824f53f5ac423368b627319071b95409491989e641eee2d7326864"
          )
        ),
        sequenceNumber = 4294967295L
      ),
      NormalTransactionInput(
        outputTransactionHash = Hash(bytes("db373a4ccea956e127dfaf2b34519c27448c17c51c37c2c6e303adc256e472fe")),
        outputIndex = 1,
        unlockingScript = UnlockingScript(
          bytes(
            "48304502210082ca0851f3a94d4e0d0067a47f6bd132b47b798a83e40e7a408011d4021d7ec5022034b75358575754bfe58229610d12749c60e7295d9472790014067d36eab88dd1012103df96db891b824f53f5ac423368b627319071b95409491989e641eee2d7326864"
          )
        ),
        sequenceNumber = 4294967295L
      ),
      NormalTransactionInput(
        outputTransactionHash = Hash(bytes("6c2bb41d2998952a63e17ba5890b38889ebec7537d77e6d6d086d3feedce6f35")),
        outputIndex = 0,
        unlockingScript = UnlockingScript(
          bytes(
            "463043022070d2b610ac64d9643a87d33d785996596612e343fe62f7a6a94f7ab732ffbb8a021f1b1bee854faa6595be856c64a8cf5086821d3867a1da5e12bc27ab5905ab9501210251571c711c89343b477ea209601542b9827dad55e1249ca35bb8cc0f65efad1c"
          )
        ),
        sequenceNumber = 4294967295L
      ),
      NormalTransactionInput(
        outputTransactionHash = Hash(bytes("ae5cfce86e33b718916fa76779c6e62ccb0596ced839940107ae832ccf29d0f4")),
        outputIndex = 2,
        unlockingScript = UnlockingScript(
          bytes(
            "473044022100fec80cc70b82274c0b292c79a1c0cb672d83b0bcc79ea61a55e7b50ae6c32f6b021f4dc2534e647bbcec0d2741e44421a080ad192edccccabc742da715980dbe940121023547f5787c54caf67be8359a482553ee83a8e77eb13526475ad17475077d888c"
          )
        ),
        sequenceNumber = 4294967295L
      )
    ),
    outputs = List(
      TransactionOutput(
        value = 61990754L,
        lockingScript = LockingScript(bytes("76a914f92a54b60ae8b9eaf4234aea1b51d0c0659d6aed88ac"))
      ),
      TransactionOutput(
        value = 37489L,
        lockingScript = LockingScript(bytes("76a91408240470d3e7e1a3dd26e7655e3fb90373bfa5bb88ac"))
      )
    ),
    lockTime = 0L
  )
  val transaction2 = Transaction(
    version = 5,
    inputs = List(
      NormalTransactionInput(
        outputTransactionHash = Hash(bytes("42828762f3233f5b4ca6d56dc8b90c7e7fd27c971860c6df7b628c6090212553")),
        outputIndex = 1,
        unlockingScript = UnlockingScript(
          bytes(
            "483045022100e55e797b51711148692b9cc4a2c80652c69bd78d4103438dec41e01670c046f802207ef80574570cfde8f6a788a6b2900343d01115645b6a037773c43df507493294012102772555483a3445bab2cdd3886a1cc9b362f4e9991db50d0944689aed90b67b19"
          )
        ),
        sequenceNumber = 4294967295L
      ),
      NormalTransactionInput(
        outputTransactionHash = Hash(bytes("b4055f82e6607c370e20f58245fb2ff304989d817b565dfa131b774176cacdb3")),
        outputIndex = 1,
        unlockingScript = UnlockingScript(
          bytes(
            "483045022100844f55bdc9bfa12f468560ee293219433ad96060538a6ee6df7d0922d7e4b80602204da8d73e024e353fb5598dda67a6afe8425677b7ee483cbb2147ced5bfc5a629012103df96db891b824f53f5ac423368b627319071b95409491989e641eee2d7326864"
          )
        ),
        sequenceNumber = 4294967295L
      ),
      NormalTransactionInput(
        outputTransactionHash = Hash(bytes("db373a4ccea956e127dfaf2b34519c27448c17c51c37c2c6e303adc256e472fe")),
        outputIndex = 1,
        unlockingScript = UnlockingScript(
          bytes(
            "48304502210082ca0851f3a94d4e0d0067a47f6bd132b47b798a83e40e7a408011d4021d7ec5022034b75358575754bfe58229610d12749c60e7295d9472790014067d36eab88dd1012103df96db891b824f53f5ac423368b627319071b95409491989e641eee2d7326864"
          )
        ),
        sequenceNumber = 4294967295L
      ),
      NormalTransactionInput(
        outputTransactionHash = Hash(bytes("6c2bb41d2998952a63e17ba5890b38889ebec7537d77e6d6d086d3feedce6f35")),
        outputIndex = 0,
        unlockingScript = UnlockingScript(
          bytes(
            "463043022070d2b610ac64d9643a87d33d785996596612e343fe62f7a6a94f7ab732ffbb8a021f1b1bee854faa6595be856c64a8cf5086821d3867a1da5e12bc27ab5905ab9501210251571c711c89343b477ea209601542b9827dad55e1249ca35bb8cc0f65efad1c"
          )
        ),
        sequenceNumber = 4294967295L
      ),
      NormalTransactionInput(
        outputTransactionHash = Hash(bytes("ae5cfce86e33b718916fa76779c6e62ccb0596ced839940107ae832ccf29d0f4")),
        outputIndex = 2,
        unlockingScript = UnlockingScript(
          bytes(
            "473044022100fec80cc70b82274c0b292c79a1c0cb672d83b0bcc79ea61a55e7b50ae6c32f6b021f4dc2534e647bbcec0d2741e44421a080ad192edccccabc742da715980dbe940121023547f5787c54caf67be8359a482553ee83a8e77eb13526475ad17475077d888c"
          )
        ),
        sequenceNumber = 4294967295L
      )
    ),
    outputs = List(
      TransactionOutput(
        value = 61990754L,
        lockingScript = LockingScript(bytes("76a914f92a54b60ae8b9eaf4234aea1b51d0c0659d6aed88ac"))
      ),
      TransactionOutput(
        value = 37489L,
        lockingScript = LockingScript(bytes("76a91408240470d3e7e1a3dd26e7655e3fb90373bfa5bb88ac"))
      )
    ),
    lockTime = 0L
  )
  val transaction3 = Transaction(
    version = 6,
    inputs = List(
      NormalTransactionInput(
        outputTransactionHash = Hash(bytes("42828762f3233f5b4ca6d56dc8b90c7e7fd27c971860c6df7b628c6090212553")),
        outputIndex = 1,
        unlockingScript = UnlockingScript(
          bytes(
            "483045022100e55e797b51711148692b9cc4a2c80652c69bd78d4103438dec41e01670c046f802207ef80574570cfde8f6a788a6b2900343d01115645b6a037773c43df507493294012102772555483a3445bab2cdd3886a1cc9b362f4e9991db50d0944689aed90b67b19"
          )
        ),
        sequenceNumber = 4294967295L
      ),
      NormalTransactionInput(
        outputTransactionHash = Hash(bytes("b4055f82e6607c370e20f58245fb2ff304989d817b565dfa131b774176cacdb3")),
        outputIndex = 1,
        unlockingScript = UnlockingScript(
          bytes(
            "483045022100844f55bdc9bfa12f468560ee293219433ad96060538a6ee6df7d0922d7e4b80602204da8d73e024e353fb5598dda67a6afe8425677b7ee483cbb2147ced5bfc5a629012103df96db891b824f53f5ac423368b627319071b95409491989e641eee2d7326864"
          )
        ),
        sequenceNumber = 4294967295L
      ),
      NormalTransactionInput(
        outputTransactionHash = Hash(bytes("db373a4ccea956e127dfaf2b34519c27448c17c51c37c2c6e303adc256e472fe")),
        outputIndex = 1,
        unlockingScript = UnlockingScript(
          bytes(
            "48304502210082ca0851f3a94d4e0d0067a47f6bd132b47b798a83e40e7a408011d4021d7ec5022034b75358575754bfe58229610d12749c60e7295d9472790014067d36eab88dd1012103df96db891b824f53f5ac423368b627319071b95409491989e641eee2d7326864"
          )
        ),
        sequenceNumber = 4294967295L
      ),
      NormalTransactionInput(
        outputTransactionHash = Hash(bytes("6c2bb41d2998952a63e17ba5890b38889ebec7537d77e6d6d086d3feedce6f35")),
        outputIndex = 0,
        unlockingScript = UnlockingScript(
          bytes(
            "463043022070d2b610ac64d9643a87d33d785996596612e343fe62f7a6a94f7ab732ffbb8a021f1b1bee854faa6595be856c64a8cf5086821d3867a1da5e12bc27ab5905ab9501210251571c711c89343b477ea209601542b9827dad55e1249ca35bb8cc0f65efad1c"
          )
        ),
        sequenceNumber = 4294967295L
      ),
      NormalTransactionInput(
        outputTransactionHash = Hash(bytes("ae5cfce86e33b718916fa76779c6e62ccb0596ced839940107ae832ccf29d0f4")),
        outputIndex = 2,
        unlockingScript = UnlockingScript(
          bytes(
            "473044022100fec80cc70b82274c0b292c79a1c0cb672d83b0bcc79ea61a55e7b50ae6c32f6b021f4dc2534e647bbcec0d2741e44421a080ad192edccccabc742da715980dbe940121023547f5787c54caf67be8359a482553ee83a8e77eb13526475ad17475077d888c"
          )
        ),
        sequenceNumber = 4294967295L
      )
    ),
    outputs = List(
      TransactionOutput(
        value = 61990754L,
        lockingScript = LockingScript(bytes("76a914f92a54b60ae8b9eaf4234aea1b51d0c0659d6aed88ac"))
      ),
      TransactionOutput(
        value = 37489L,
        lockingScript = LockingScript(bytes("76a91408240470d3e7e1a3dd26e7655e3fb90373bfa5bb88ac"))
      )
    ),
    lockTime = 0L
  )

}
