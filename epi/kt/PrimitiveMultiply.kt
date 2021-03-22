package epi.kt

object PrimitiveMultiply {
    fun multiply(x: Long, y: Long): Long {
        var lX = x
        var lY = y
        var rt = 0L

        while(lX > 0) {
            if(lX and 1 != 0L) {
                rt = sum(rt, lY)
            }

            lX = lX shr (1)
            lY = lY shl (1)
        }

        return rt
    }

    private fun sum(x: Long, y: Long): Long {
        var tX = x
        var tY = y
        var k = 1L
        var sum = 0L
        var carryIn = 0L

        while(tX > 0 || tY > 0) {
            val kX = x and k
            val kY = y and k
            val carryOut = (kX and kY) or (kX and carryIn) or (kY and carryIn)
            sum = sum or (kX xor(kY) xor(carryIn))
            carryIn = carryOut shl(1)
            k = k shl(1)
            tX = tX shr(1)
            tY = tY shr(1)
        }

        return sum or carryIn
    }
}