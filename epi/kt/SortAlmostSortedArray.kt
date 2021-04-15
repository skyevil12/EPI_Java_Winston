package epi.kt

import java.util.*

object SortAlmostSortedArray {
    fun sortApproximatelySortedData(sequence: Iterator<Int>, k: Int) : List<Int> {
        val rt = mutableListOf<Int>()
        val pq = PriorityQueue<Int>()
        /*
            (3,-1,2,6,4,5,8}
            k 2

            pq  6, 8
            rt  -1, 2, 3, 4, 5
         */

        //T O(Nlogk)    S O(k)
        while(sequence.hasNext()) {
            pq.offer(sequence.next())
            if(pq.size > k) {
                rt.add(pq.poll())
            }
        }

        while(pq.isNotEmpty()) {
            rt.add(pq.poll())
        }

        return rt
    }
}