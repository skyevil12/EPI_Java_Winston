package epi.kt

object ReplaceAndRemove {
    //Kotlin has array type? : CharArray
    fun replaceAndRemove(size: Int, s: CharArray): Int {
        //could declare in the same line? var wIdx = 0; var rt = size
        var wIdx = 0
        var rt = size

        for(i in 0 until size) {
            val cur = s[i]
            if(cur != 'b') {
                if(cur == 'a') {
                    rt++
                }
                s[wIdx++] = cur
            } else {
                rt--
            }
        }

        var j = rt - 1
        for(i in wIdx - 1 downTo  0) {
            var cur = s[i]
            if(cur == 'a') {
                s[j--] = 'd'
                s[j--] = 'd'
            } else {
                s[j--] = cur
            }
        }

        return rt
    }
}