package epi.kt

import java.lang.StringBuilder

object ConvertBase {
    fun convertBase(numAsString: String, b1: Int, b2: Int) : String {
        if(numAsString.isEmpty() || numAsString == "0") {
            return numAsString
        }

        var st = 0
        var isNeg = false
        var rtSb = StringBuilder()
        var tmp = 0L

        if(numAsString[st] == '+') {
            st++
        } else if(numAsString[st] == '-') {
            st++
            isNeg = true
        }

        for(i in st until numAsString.length) {
            tmp = tmp * b1 + chToInt(numAsString[i])
        }

        while(tmp > 0) {
            rtSb.append(intToCh((tmp % b2).toInt()))
            tmp /= b2
        }

        if(isNeg) {
            rtSb.append('-')
        }

        return rtSb.reverse().toString()
    }

    fun chToInt(ch : Char) : Int {
        return if(Character.isDigit(ch)) {
            ch - '0';
        } else {
            10 + (ch - 'A');
        }
    }

    fun intToCh(num: Int) : Char {
        return if(num >= 10) {
            'A'.plus(num - 10)
        } else {
            '0'.plus(num)
        }
    }
}