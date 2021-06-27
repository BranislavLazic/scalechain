package io.scalechain.blockchain.api.command.utility.p1

import io.scalechain.blockchain.api.command.RpcCommand
import io.scalechain.blockchain.api.domain.{ RpcError, RpcRequest, RpcResult }

/*
  CLI command :
    bitcoin-cli -testnet validateaddress mgnucj8nYqdrPFh2JfZSB1NmUThUGnmsqe

  CLI output :
    {
        "isvalid" : true,
        "address" : "mgnucj8nYqdrPFh2JfZSB1NmUThUGnmsqe",
        "ismine" : true,
        "iswatchonly" : false,
        "isscript" : false,
        "pubkey" : "03bacb84c6464a58b3e0a53cc0ba4cb3b82848cd7bed25a7724b3cc75d76c9c1ba",
        "iscompressed" : true,
        "account" : "test label"
    }

  Json-RPC request :
    {"jsonrpc": "1.0", "id":"curltest", "method": "validateaddress", "params": [] }

  Json-RPC response :
    {
      "result": << Same to CLI Output >> ,
      "error": null,
      "id": "curltest"
    }
 */

/** ValidateAddress: returns information about the given Bitcoin address.
  *
  * https://bitcoin.org/en/developer-reference#validateaddress
  */
object ValidateAddress extends RpcCommand {
  def invoke(request: RpcRequest): Either[RpcError, Option[RpcResult]] = {
    // TODO : Implement
    assert(false)
    Right(None)
  }
  def help(): String =
    """validateaddress "bitcoinaddress"
      |
      |Return information about the given bitcoin address.
      |
      |Arguments:
      |1. "bitcoinaddress"     (string, required) The bitcoin address to validate
      |
      |Result:
      |{
      |  "isvalid" : true|false,       (boolean) If the address is valid or not. If not, this is the only property returned.
      |  "address" : "bitcoinaddress", (string) The bitcoin address validated
      |  "scriptPubKey" : "hex",       (string) The hex encoded scriptPubKey generated by the address
      |  "ismine" : true|false,        (boolean) If the address is yours or not
      |  "iswatchonly" : true|false,   (boolean) If the address is watchonly
      |  "isscript" : true|false,      (boolean) If the key is a script
      |  "pubkey" : "publickeyhex",    (string) The hex value of the raw public key
      |  "iscompressed" : true|false,  (boolean) If the address is compressed
      |  "account" : "account"         (string) DEPRECATED. The account associated with the address, "" is the default account
      |}
      |
      |Examples:
      |> bitcoin-cli validateaddress "1PSSGeFHDnKNxiEyFrD1wcEaHr9hrQDDWc"
      |> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "validateaddress", "params": ["1PSSGeFHDnKNxiEyFrD1wcEaHr9hrQDDWc"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
    """.stripMargin
}
