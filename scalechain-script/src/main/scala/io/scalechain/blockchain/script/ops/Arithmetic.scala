package io.scalechain.blockchain.script.ops

import java.math.BigInteger

import io.scalechain.blockchain.script.{ ScriptEnvironment, ScriptValue }
import io.scalechain.blockchain.{ ErrorCode, FatalException, ScriptEvalException }
import io.scalechain.util.Utils

trait Arithmetic extends ScriptOp {
  def unaryIntOperation(env: ScriptEnvironment, mutate: (Long) => (Long)): Unit =
    super.unaryOperation(
      env,
      (value1: ScriptValue) => {
        val intValue1 = ScriptValue.decodeStackInt(value1.value)

        val intResult = mutate(intValue1.longValue())
        ScriptValue.valueOf(intResult)
      }
    )

  def binaryIntOperation(env: ScriptEnvironment, mutate: (Long, Long) => (Long)): Unit =
    super.binaryOperation(
      env,
      (value1: ScriptValue, value2: ScriptValue) => {
        val intValue1 = ScriptValue.decodeStackInt(value1.value)
        val intValue2 = ScriptValue.decodeStackInt(value2.value)

        val intResult = mutate(intValue1.longValue(), intValue2.longValue())
        ScriptValue.valueOf(intResult)
      }
    )

  def ternaryIntOperation(env: ScriptEnvironment, mutate: (Long, Long, Long) => (Long)): Unit =
    super.ternaryOperation(
      env,
      (value1: ScriptValue, value2: ScriptValue, value3: ScriptValue) => {
        val intValue1 = ScriptValue.decodeStackInt(value1.value)
        val intValue2 = ScriptValue.decodeStackInt(value2.value)
        val intValue3 = ScriptValue.decodeStackInt(value3.value)

        val intResult = mutate(intValue1.longValue(), intValue2.longValue(), intValue3.longValue())
        ScriptValue.valueOf(intResult)
      }
    )
}

/** OP_1ADD(0x8b) : Add 1 to the top item
  */
case class Op1Add() extends Arithmetic {
  def opCode() = OpCode(0x8b)

  def execute(env: ScriptEnvironment): Unit =
    unaryIntOperation(env, _ + 1L)
}

/** OP_1SUB(0x8c) : Subtract 1 from the top item
  */
case class Op1Sub() extends Arithmetic {
  def opCode() = OpCode(0x8c)

  def execute(env: ScriptEnvironment): Unit =
    unaryIntOperation(env, _ - 1L)
}

/** OP_2MUL(0x8d) : Disabled (multiply top item by 2)
  */
case class Op2Mul() extends Arithmetic with DisabledScriptOp {
  def opCode() = OpCode(0x8d)
}

/** OP_2DIV(0x8e) : Disabled (divide top item by 2)
  */
case class Op2Div() extends Arithmetic with DisabledScriptOp {
  def opCode() = OpCode(0x8e)
}

/** OP_NEGATE(0x8f) : Flip the sign of top item
  */
case class OpNegate() extends Arithmetic {
  def opCode() = OpCode(0x8f)
  def execute(env: ScriptEnvironment): Unit =
    unaryIntOperation(env, -_)
}

/** OP_ABS(0x90) : Change the sign of the top item to positive
  */
case class OpAbs() extends Arithmetic {
  def opCode() = OpCode(0x90)

  def execute(env: ScriptEnvironment): Unit =
    unaryIntOperation(env, Math.abs(_))
}

/** OP_NOT(0x91) : If the input is 0 or 1, it is flipped. Otherwise the output will be 0.
  */
case class OpNot() extends Arithmetic {
  def opCode() = OpCode(0x91)

  def execute(env: ScriptEnvironment): Unit =
    unaryIntOperation(
      env,
      value =>
        if (value == 0L)
          1L
        else if (value == 1L)
          0L
        else
          0L
    )
}

/** OP_0NOTEQUAL(0x92) : Returns 0 if the input is 0. 1 otherwise.
  */
case class Op0NotEqual() extends Arithmetic {
  def opCode() = OpCode(0x92)

  def execute(env: ScriptEnvironment): Unit =
    unaryIntOperation(env, value => (if (value == 0L) 0L else 1L))
}

/** OP_ADD(0x93) : Pop top two items, add them and push result
  */
case class OpAdd() extends Arithmetic {
  def opCode() = OpCode(0x93)

  def execute(env: ScriptEnvironment): Unit =
    binaryIntOperation(env, _ + _)
}

/** OP_SUB(0x94) : Pop top two items, subtract first from second, push result
  */
case class OpSub() extends Arithmetic {
  def opCode() = OpCode(0x94)

  def execute(env: ScriptEnvironment): Unit =
    binaryIntOperation(env, _ - _)
}

/** OP_MUL(0x95) : Disabled (multiply top two items)
  */
case class OpMul() extends Arithmetic with DisabledScriptOp {
  def opCode() = OpCode(0x95)
}

/** OP_DIV(0x96) : Disabled (divide second item by first item)
  */
case class OpDiv() extends Arithmetic with DisabledScriptOp {
  def opCode() = OpCode(0x96)
}

/** OP_MOD(0x97) : Disabled (remainder divide second item by first item)
  */
case class OpMod() extends Arithmetic with DisabledScriptOp {
  def opCode() = OpCode(0x97)
}

/** OP_LSHIFT(0x98) : Disabled (shift second item left by first item number of bits)
  */
case class OpLShift() extends Arithmetic with DisabledScriptOp {
  def opCode() = OpCode(0x98)
}

/** OP_RSHIFT(0x99) : Disabled (shift second item right by first item number of bits)
  */
case class OpRShift() extends Arithmetic with DisabledScriptOp {
  def opCode() = OpCode(0x99)
}

/** OP_BOOLAND(0x9a) : Boolean AND of top two items
  */
case class OpBoolAnd() extends Arithmetic {
  def opCode() = OpCode(0x9a)
  def execute(env: ScriptEnvironment): Unit =
    binaryIntOperation(env, ((l, r) => if (l != 0L && r != 0L) 1L else 0L))
}

/** OP_BOOLOR(0x9b) : Boolean OR of top two items
  */
case class OpBoolOr() extends Arithmetic {
  def opCode() = OpCode(0x9b)

  def execute(env: ScriptEnvironment): Unit =
    binaryIntOperation(env, ((l, r) => if (l != 0L || r != 0L) 1L else 0L))
}

/** OP_NUMEQUAL(0x9c) : Return TRUE if top two items are equal numbers
  */
case class OpNumEqual() extends Arithmetic {
  def opCode() = OpCode(0x9c)

  def execute(env: ScriptEnvironment): Unit =
    binaryIntOperation(env, ((l, r) => if (l == r) 1L else 0L))
}

/** OP_NUMEQUALVERIFY(0x9d) : Same as OP_NUMEQUAL, but runs OP_VERIFY afterward.
  */
case class OpNumEqualVerify() extends Arithmetic {
  def opCode() = OpCode(0x9d)

  def execute(env: ScriptEnvironment): Unit = {
    binaryIntOperation(env, ((l, r) => if (l == r) 1L else 0L))

    unaryIntOperation(
      env,
      (
          value =>
            if (value != 0L) value
            else throw new ScriptEvalException(ErrorCode.InvalidTransaction, "ScriptOp:OpNumEqualVerify")
      )
    )
  }
}

/** OP_NUMNOTEQUAL(0x9e) : Return TRUE if top two items are not equal numbers
  */
case class OpNumNotEqual() extends Arithmetic {
  def opCode() = OpCode(0x9e)

  def execute(env: ScriptEnvironment): Unit =
    binaryIntOperation(env, ((l, r) => if (l != r) 1L else 0L))
}

/** OP_LESSTHAN(0x9f) : Return TRUE if second item is less than top item
  */
case class OpLessThan() extends Arithmetic {
  def opCode() = OpCode(0x9f)

  def execute(env: ScriptEnvironment): Unit =
    binaryIntOperation(env, ((l, r) => if (l < r) 1L else 0L))
}

/** OP_GREATERTHAN(0xa0) : Return TRUE if second item is greater than top item
  */
case class OpGreaterThan() extends Arithmetic {
  def opCode() = OpCode(0xa0)

  def execute(env: ScriptEnvironment): Unit =
    binaryIntOperation(env, ((l, r) => if (l > r) 1L else 0L))
}

/** OP_LESSTHANOREQUAL(0xa1) : Return TRUE if second item is less than or equal to top item
  */
case class OpLessThanOrEqual() extends Arithmetic {
  def opCode() = OpCode(0xa1)

  def execute(env: ScriptEnvironment): Unit =
    binaryIntOperation(env, ((l, r) => if (l <= r) 1L else 0L))
}

/** OP_GREATERTHANOREQUAL(0xa2) : Return TRUE if second item is great than or equal to top item
  */
case class OpGreaterThanOrEqual() extends Arithmetic {
  def opCode() = OpCode(0xa2)

  def execute(env: ScriptEnvironment): Unit =
    binaryIntOperation(env, ((l, r) => if (l >= r) 1L else 0L))
}

/** OP_MIN(0xa3) : Return the smaller of the two top items
  */
case class OpMin() extends Arithmetic {
  def opCode() = OpCode(0xa3)

  def execute(env: ScriptEnvironment): Unit =
    binaryIntOperation(env, Math.min(_, _))
}

/** OP_MAX(0xa4) : Return the larger of the two top items
  */
case class OpMax() extends Arithmetic {
  def opCode() = OpCode(0xa4)

  def execute(env: ScriptEnvironment): Unit =
    binaryIntOperation(env, Math.max(_, _))
}

/** OP_WITHIN(0xa5) : Return TRUE if the third item is between the second item (or equal) and first item
  * Returns 1 if x is within the specified range (left-inclusive), 0 otherwise.
  */
case class OpWithin() extends Arithmetic {
  def opCode() = OpCode(0xa5)

  def execute(env: ScriptEnvironment): Unit =
    ternaryIntOperation(env, ((x, min, max) => if ((min <= x) && (x < max)) 1L else 0L))
}
