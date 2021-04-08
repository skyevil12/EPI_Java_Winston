package epi.kt

import java.util.*

object SortedArraysMerge {
    fun mergeSortedArrays(sortedArrays: List<List<Int>>) : List<Int> {
        val rtList = mutableListOf<Int>()
        //int[] 0 is val, 1 is outer index 2 is list index
        var q = PriorityQueue<IntArray>(kotlin.Comparator { o1, o2 ->  o1[0].compareTo(o2[0])})
        //T O(k)
        for(i in sortedArrays.indices) {
            if(sortedArrays[i].isNotEmpty()) {
                q.offer(intArrayOf(sortedArrays[i][0], i, 0))
            }
        }

        //T O(Nlogk)    S O(k)
        while(q.isNotEmpty()) {
            val s = q.poll()
            rtList.add(s[0])
            if(s[2] + 1 < sortedArrays[s[1]].size) {
                q.offer(intArrayOf(sortedArrays[s[1]][s[2] + 1], s[1], s[2] + 1))
            }
        }

        return rtList
    }
}