package epi.kt

import epi.RealSquareRoot
import java.lang.IllegalArgumentException

object RealSquareRoot {
    //T O(log(x /eps)) S O(1)
    fun squareRoot(x: Double) : Double {
        if(x < 0) {
            throw IllegalArgumentException("Invalid input")
        }
        /*
            for x which bigger than 1, its sqrt would be always bigger than 1
            for x which smaller than 1, its sqrt would be always smaller than 1
         */
        val EPSILON = 0.000000000000001
        var l = 1.0
        var r = x
        if(x < 1) {
            l = x
            r = 1.0
        }

        while(RealSquareRoot.compare(l, r) <= 0) {
            val m = l + (r - l) * 0.5
            val mVal = m * m
            val cmpRt = RealSquareRoot.compare(mVal, x)
            when {
                cmpRt == 0 -> {
                    return m
                }
                //Why not increase or decrease? because once we increase or decrease
                cmpRt > 0 -> {
                    r = m
                }
                else -> {
                    l = m
                }
            }
        }

        throw IllegalArgumentException("Invalid input")
    }
}