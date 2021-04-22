package epi.kt

import java.util.*

object KLargestInHeap {
    fun kLargestInBinaryHeap(A: List<Int>, k : Int): List<Int> {
        val rt = mutableListOf<Int>()
        val queue = PriorityQueue<Int>(kotlin.Comparator { o1, o2 ->  A[o2] - A[o1]})

        queue.offer(0)
        //T O(KlogK) S O(K)
        while(rt.size < k) {
            val i = queue.poll()
            rt.add(A[i])
            if(2 * i + 1 < A.size) {
                queue.offer(2 * i + 1)
            }

            if(2 * i + 2 < A.size) {
                queue.offer(2 * i + 2)
            }
        }
        return rt
    }
}