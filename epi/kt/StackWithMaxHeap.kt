package epi.kt

import java.util.*

open class StackWithMaxHeap {
    var inQueue = PriorityQueue<Array<Int>>(kotlin.Comparator { o1, o2 ->  o2[0] - o1[0]})
    val pq = PriorityQueue<Int>(Collections.reverseOrder())
    var idx = -1
    fun empty() : Boolean {
        return inQueue.isEmpty()
    }

    fun max() : Int {
        pq.clear()
        var it = inQueue.iterator()
        while(it.hasNext()) {
            pq.offer(it.next()[1])
        }
        return pq.peek()
    }

    fun pop() : Int {
        return inQueue.poll()[1]
    }

    fun push(x : Int) {
        inQueue.offer(arrayOf(idx++, x))
    }
}