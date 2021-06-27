package io.scalechain.blockchain.storage.record

import java.io.File
import java.nio.ByteBuffer

import io.scalechain.blockchain.proto.codec.MessagePartCodec
import io.scalechain.blockchain.proto.{ ProtocolMessage, RecordLocator }
import io.scalechain.blockchain.{ BlockStorageException, ErrorCode }

/** A record file that contains set of records.
  *
  * For reading/writing a file, we use random access file to get the file channel, and read/write from the channel.
  *
  * Details :
  * http://tutorials.jenkov.com/java-nio/file-channel.html
  */
class RecordFile(val path: File, maxFileSize: Long) extends BlockAccessFile(path, maxFileSize) {
  // Move to the end of file so that we can append records at the end of the file.
  moveTo(size())

  def readRecord[T <: ProtocolMessage](locator: RecordLocator)(implicit codec: MessagePartCodec[T]): T = {

    val buffer = read(locator.offset, locator.size)
    codec.parse(buffer.array())
  }

  def appendRecord[T <: ProtocolMessage](record: T)(implicit codec: MessagePartCodec[T]): RecordLocator = {
    // Move to the end of the file if we are not.
    if (offset() <= size())
      moveTo(size())

    val serializedBytes = codec.serialize(record)
    val initialOffset   = offset()
    val buffer          = ByteBuffer.wrap(serializedBytes)
    if (initialOffset + buffer.capacity() > maxFileSize)
      throw new BlockStorageException(ErrorCode.OutOfFileSpace)
    append(buffer)
    RecordLocator(initialOffset, buffer.capacity())
  }
}
