package epi.kt

import java.util.*


open class QueueWithMax {
    private val q = ArrayDeque<Int>()
    private val maxQ = ArrayDeque<Int>()

    fun enqueue(x : Int) {
        q.offer(x)
        //Remove from last because we maintain a descending queue
        while(!maxQ.isEmpty() && maxQ.peekLast() < x) {
            maxQ.pollLast()
        }
        maxQ.offer(x)
    }

    fun dequeue() : Int {
        val rt = q.poll()
        if(maxQ.peek() == rt) {
            maxQ.poll()
        }
        return rt
    }

    fun max() : Int {
        return maxQ.peek()
    }
}