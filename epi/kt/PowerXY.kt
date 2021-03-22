package epi.kt

import kotlin.math.abs

object PowerXY {
    fun power(x: Double, y: Int): Double {
        var absY = abs(y)
        var rt = 1.0
        var lX = x
        while(absY != 0) {
            if((absY and 1) != 0) {
                rt *= lX
            }

            lX *= lX
            absY = absY ushr(1)
        }

        return if(y < 0) {
            1 / rt
        } else {
            rt
        }
    }
}