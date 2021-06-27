package io.scalechain.blockchain.proto.codec.primitive

/** Source code copied from : https://github.com/yzernik/bitcoin-scodec
  * Thanks to : https://github.com/yzernik
  */

import org.scalacheck.{ Arbitrary, Gen }
// import org.scalatest.prop.GeneratorDrivenPropertyChecks
import scodec._
import scodec.bits.BitVector
import shapeless.Lazy

import scala.collection.GenTraversable
import scala.concurrent.duration._
import org.scalatest._
import Arbitrary._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

abstract class CodecSuite extends AnyWordSpec with Matchers with ScalaCheckDrivenPropertyChecks {

  protected def roundtrip[A](a: A)(implicit c: Lazy[Codec[A]]): Unit =
    roundtrip(c.value, a)

  protected def roundtrip[A](codec: Codec[A], value: A): Unit = {
    val encoded = codec.encode(value)
    encoded shouldBe 'successful
    val Attempt.Successful(DecodeResult(decoded, remainder)) = codec.decode(encoded.require)
    remainder shouldEqual BitVector.empty
    decoded shouldEqual value
  }

  protected def roundtripAll[A](codec: Codec[A], as: GenTraversable[A]): Unit =
    as foreach { a => roundtrip(codec, a) }

  protected def encodeError[A](codec: Codec[A], a: A, err: Err): Unit = {
    val encoded = codec.encode(a)
    encoded shouldBe Attempt.Failure(err)
  }

  protected def shouldDecodeFullyTo[A](codec: Codec[A], buf: BitVector, expected: A): Unit = {
    val Attempt.Successful(DecodeResult(actual, rest)) = codec decode buf
    rest shouldBe BitVector.empty
    actual shouldBe expected
  }

  protected def time[A](f: => A): (A, FiniteDuration) = {
    val start   = System.nanoTime
    val result  = f
    val elapsed = (System.nanoTime - start).nanos
    (result, elapsed)
  }

  protected def samples[A](gen: Gen[A]): Stream[Option[A]] =
    Stream.continually(gen.sample)

  protected def definedSamples[A](gen: Gen[A]): Stream[A] =
    samples(gen).flatMap(x => x)

  implicit def arbBitVector: Arbitrary[BitVector] = Arbitrary(arbitrary[Array[Byte]].map(BitVector.apply))
}
