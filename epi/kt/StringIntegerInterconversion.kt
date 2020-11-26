package epi.kt

import java.lang.StringBuilder

object StringIntegerInterconversion {
    fun stringToInteger(s: String): Int {
        var rt = 0L
        if(s.isEmpty) {
            return 0
        }

        var isNeg = false
        var st = 0
        if(!Character.isDigit(s[st])) {
            if(s[st] == '-') {
                isNeg = true
            }
            st++
        }

        for(i in st until s.length) {
            var ch = s[i]
            rt = rt * 10 + (ch - '0')
        }

        if(isNeg) {
            return -rt.toInt()
        }

        return rt.toInt()
    }

    fun integerToString(number: Int): String {
        if(number == 0) {
            return "0";
        }

        var rtSb = StringBuilder()
        var isNeg = number < 0
        var lNumber = number.toLong()
        if(isNeg) {
            lNumber *= -1
        }

        while(lNumber > 0) {
            rtSb.append(lNumber % 10)
            lNumber /= 10
        }

        if(isNeg) {
            rtSb.append('-')
        }

        return rtSb.reverse().toString()
    }
}