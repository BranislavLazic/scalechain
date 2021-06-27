package io.scalechain.blockchain.api

import io.scalechain.blockchain.api.command._
import io.scalechain.blockchain.api.command.blockchain.p1.GetTxOut
import io.scalechain.blockchain.api.command.control.p1.GetInfo
import io.scalechain.blockchain.api.domain.{ RpcError, RpcRequest, RpcResponse }
import org.slf4j.{ Logger, LoggerFactory }
import spray.json._

trait ServiceDispatcher {
  //private val logger = LoggerFactory.getLogger(classOf[ServiceDispatcher])

  // A map from Json-Rpc method to the actual JsonRpcService object that handles it.
  def dispatch(request: RpcRequest): RpcResponse = {
    //logger.info(s"new RPC request : ${request}")
    //println(s"new RPC request : ${request}")

    val methodName    = request.method
    val serviceOption = Services.serviceByCommand.get(methodName)

    if (serviceOption.isDefined) {
      val serviceResult = serviceOption.get.invoke(request)
      serviceResult match {
        case Left(rpcError) =>
          RpcResponse(
            result = None,
            error = Some(rpcError),
            id = request.id
          )
        case Right(rpcResultOption) =>
          RpcResponse(
            result = rpcResultOption,
            error = None,
            id = request.id
          )
      }
    } else
      RpcResponse(
        result = None,
        error = Some(
          RpcError(
            code = RpcError.RPC_METHOD_NOT_FOUND.code,
            message = RpcError.RPC_METHOD_NOT_FOUND.messagePrefix,
            data = methodName
          )
        ),
        id = request.id
      )
  }
}
