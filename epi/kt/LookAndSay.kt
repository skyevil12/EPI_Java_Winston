package epi.kt

import java.lang.StringBuilder

object LookAndSay {
    fun lookAndSay(n: Int): String {
        if(n <= 0) {
            return ""
        }

        var rt = "1"
        var cnt = 0
        var ch = '0'
        var tmpSb = StringBuilder()
        /*
        <1,11, 21,1211,111221,312211,13112221,1113213211>.
        T O(N * 2^N) S O(2N)
         */
        for(i in 1 until n) {
            var j = 0
            while(j < rt.length) {
                ch = rt[j]
                cnt = 1
                while(j + 1 < rt.length && ch == rt[j + 1]) {
                    cnt++
                    j++
                }
                tmpSb.append(cnt).append(ch)
                j++
            }
            rt = tmpSb.toString()
            tmpSb.setLength(0)
        }

        return rt
    }
}