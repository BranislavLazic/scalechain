package io.scalechain.blockchain.api.command.wallet.p2

import io.scalechain.blockchain.api.command.RpcCommand
import io.scalechain.blockchain.api.domain.{ RpcError, RpcRequest, RpcResult }

/*
  CLI command :
    # Put the address indicated below in the “doc test” account.
    bitcoin-cli -testnet setaccount \
      mmXgiR6KAhZCyQ8ndr2BCfEq1wNG2UnyG6 "doc test"

  CLI output :
    (no output)

  Json-RPC request :
    {"jsonrpc": "1.0", "id":"curltest", "method": "setacount", "params": [] }

  Json-RPC response :
    {
      "result": null,
      "error": null,
      "id": "curltest"
    }
 */

/** SetAccount: puts the specified address in the given account.
  *
  * https://bitcoin.org/en/developer-reference#setaccount
  */
object SetAccount extends RpcCommand {
  def invoke(request: RpcRequest): Either[RpcError, Option[RpcResult]] = {
    // TODO : Implement
    assert(false)
    Right(None)
  }
  def help(): String =
    """setaccount "bitcoinaddress" "account"
      |
      |DEPRECATED. Sets the account associated with the given address.
      |
      |Arguments:
      |1. "bitcoinaddress"  (string, required) The bitcoin address to be associated with an account.
      |2. "account"         (string, required) The account to assign the address to.
      |
      |Examples:
      |> bitcoin-cli setaccount "1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XZ" "tabby"
      |> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "setaccount", "params": ["1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XZ", "tabby"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
    """.stripMargin
}
