package io.scalechain.blockchain.api.command.wallet.p3

import io.scalechain.blockchain.api.command.RpcCommand
import io.scalechain.blockchain.api.domain.{ RpcError, RpcRequest, RpcResult }

/*
  CLI command :
    bitcoin-cli -testnet listlockunspent

  CLI output :
    [
        {
            "txid" : "ca7cb6a5ffcc2f21036879493db4530c0ce9b5bff9648f9a3be46e2dfc8e0166",
            "vout" : 0
        }
    ]

  Json-RPC request :
    {"jsonrpc": "1.0", "id":"curltest", "method": "listlockunspent", "params": [] }

  Json-RPC response :
    {
      "result": << Same to CLI Output >> ,
      "error": null,
      "id": "curltest"
    }
 */

/** ListLockUnspent: returns a list of temporarily unspendable (locked) outputs.
  *
  * https://bitcoin.org/en/developer-reference#listlockunspent
  */
object ListLockUnspent extends RpcCommand {
  def invoke(request: RpcRequest): Either[RpcError, Option[RpcResult]] = {
    // TODO : Implement
    assert(false)
    Right(None)
  }
  def help(): String =
    """listlockunspent
      |
      |Returns list of temporarily unspendable outputs.
      |See the lockunspent call to lock and unlock transactions for spending.
      |
      |Result:
      |[
      |  {
      |    "txid" : "transactionid",     (string) The transaction id locked
      |    "vout" : n                      (numeric) The vout value
      |  }
      |  ,...
      |]
      |
      |Examples:
      |
      |List the unspent transactions
      |> bitcoin-cli listunspent
      |
      |Lock an unspent transaction
      |> bitcoin-cli lockunspent false "[{\"txid\":\"a08e6907dbbd3d809776dbfc5d82e371b764ed838b5655e72f463568df1aadf0\",\"vout\":1}]"
      |
      |List the locked transactions
      |> bitcoin-cli listlockunspent
      |
      |Unlock the transaction again
      |> bitcoin-cli lockunspent true "[{\"txid\":\"a08e6907dbbd3d809776dbfc5d82e371b764ed838b5655e72f463568df1aadf0\",\"vout\":1}]"
      |
      |As a json rpc call
      |> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "listlockunspent", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
    """.stripMargin
}
