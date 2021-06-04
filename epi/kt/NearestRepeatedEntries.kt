package epi.kt

object NearestRepeatedEntries {
    fun findNearestRepetition(paragraph: List<String>) : Int {
        val strCache = HashMap<String, Int>()
        var rt = Int.MAX_VALUE

        for(i in paragraph.indices) {
            val cur = paragraph[i]
            /*
                // strCache[cur]?.let{
//rt = Math.min(rt, i - strCache[cur])
// }
//4 basic extension function

             */
            if(strCache.containsKey(cur)) {
                rt = Math.min(rt, i - strCache[cur]!!)
            }

            strCache[cur] = i
        }

        return if(rt == Int.MAX_VALUE) {
            -1
        } else {
            rt
        }
    }
}