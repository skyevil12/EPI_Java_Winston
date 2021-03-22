package epi.kt

import kotlin.math.abs

object ReverseDigits {
    fun reverse(x: Int): Long {
        var absX = abs(x)
        var rt = 0L
        while(absX > 0) {
            rt = rt * 10 + absX % 10
            absX /= 10
        }

        return if(x < 0) {
            -rt
        } else {
            rt
        }
    }
}