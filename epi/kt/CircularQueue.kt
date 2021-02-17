package epi.kt

import java.util.*

class CircularQueue {
    open class Queue(capacity : Int) {
        var cap = capacity
        var cnt = 0
        var head = 0
        var tail = 0
        var queue = IntArray(cap)

        fun rotate(dis : Int) {
            var lDis = dis
            if(dis == 0) {
                return
            }

            lDis += queue.size
            lDis %= queue.size
            reverse(queue, 0, queue.size - 1 - lDis)
            reverse(queue, queue.size - lDis, queue.size - 1)
            reverse(queue, 0, queue.size - 1)
        }

        fun reverse(array: IntArray, st : Int, ed : Int) {
            var st1 = st
            var ed1 = ed
            while(st1 < ed1) {
                val tmp = array[st1]
                array[st1] = array[ed1]
                array[ed1] = tmp
                st1++
                ed1--
            }
        }

        fun enqueue(x : Int) {
            if(cnt == cap) {
                //How to use it correctly??
//                Collections.rotate(listOf(queue), -head)
                rotate(-head)
                cap *= 2
                head = 0
                tail = cnt
                queue = queue.copyOf(cap)
            }
            queue[tail++] = x
            tail %= cap
            cnt++
        }

        fun dequeue() : Int {
            val rt = queue[head++]
            head %= cap
            cnt--
            return rt
        }

        fun size() : Int {
            return cnt
        }

        override fun toString() : String {
            return queue.toString()
        }
    }
}