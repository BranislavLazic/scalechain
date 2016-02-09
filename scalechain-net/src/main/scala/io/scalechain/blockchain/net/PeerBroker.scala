package io.scalechain.blockchain.net

import java.net.InetSocketAddress

import akka.actor.{Props, ActorRef, Actor}
import io.scalechain.blockchain.proto.ProtocolMessage

import scala.collection.mutable

/** Forwards a message to a PeerNodes based on the remote address of the peer.
 * - A peer broker knows which peer node is for a specific remote address.
 * - Server consumer and client producer forwards messages to the peer broker.
 * - The peer broker forwards messages to a peer node based on the remote address of the peer.
 */
class PeerBroker extends Actor {
  val peerByAddress = mutable.HashMap[InetSocketAddress, ActorRef]()

  def getPeerByAddress(remotePeerAddress : InetSocketAddress) : ActorRef = {
    val peer = peerByAddress.get(remotePeerAddress) match {
      case Some(node : ActorRef) => node
      case None => {
        val node = context.actorOf(PeerNode())
        peerByAddress.put(remotePeerAddress, node)
        node
      }
    }
    peer
  }

  def receive = {
    case (remotePeerAddress:InetSocketAddress, protocolMessage:ProtocolMessage) => {
      val peer = getPeerByAddress(remotePeerAddress)
      peer forward protocolMessage
    }
  }
}