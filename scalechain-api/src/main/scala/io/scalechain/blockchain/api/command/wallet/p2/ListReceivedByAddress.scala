package io.scalechain.blockchain.api.command.wallet.p2

import io.scalechain.blockchain.api.command.RpcCommand
import io.scalechain.blockchain.api.domain.{ RpcError, RpcRequest, RpcResult }

/*
  CLI command :
    # List addresses with balances confirmed by at least six blocks, including watch-only .addresses
    bitcoin-cli -testnet listreceivedbyaddress 6 false true

  CLI output :
    [
        {
            "address" : "mnUbTmdAFD5EAg3348Ejmonub7JcWtrMck",
            "account" : "test1",
            "amount" : 1.99900000,
            "confirmations" : 55680,
            "txids" : [
                "4d71a6127796766c39270881c779b6e05183f2bf35589261e9572436356f287f",
                "997115d0cf7b83ed332e6c1f2e8c44f803c95ea43490c84ce3e9ede4b2e1605f"
            ]
        },
        {
            "involvesWatchonly" : true,
            "address" : "n3GNqMveyvaPvUbH469vDRadqpJMPc84JA",
            "account" : "someone else's address2",
            "amount" : 0.00050000,
            "confirmations" : 34714,
            "txids" : [
                "99845fd840ad2cc4d6f93fafb8b072d188821f55d9298772415175c456f3077d"
            ]
        }
    ]

  Json-RPC request :
    {"jsonrpc": "1.0", "id":"curltest", "method": "listreceivedbyaddress", "params": [] }

  Json-RPC response :
    {
      "result": << Same to CLI Output >> ,
      "error": null,
      "id": "curltest"
    }
 */

/** ListReceivedByAddress: lists the total number of bitcoins received by each address.
  *
  * Updated in 0.10.0
  *
  * https://bitcoin.org/en/developer-reference#listreceivedbyaddress
  */
object ListReceivedByAddress extends RpcCommand {
  def invoke(request: RpcRequest): Either[RpcError, Option[RpcResult]] = {
    // TODO : Implement
    assert(false)
    Right(None)
  }
  def help(): String =
    """

"""
}
