package epi.kt

import java.util.*
import kotlin.math.min

object OnlineMedian {
    fun onlineMedian(sequence : Iterator<Int>) : List<Double> {
        val minHeap = PriorityQueue<Int>()
        val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())

        val rtList = ArrayList<Double>()
        /*
            1 0 3 5 2 0 1

            minH
            1 2 3 5

            maxH
            1 0 0
         */
        while(sequence.hasNext()) {
            val cur = sequence.next()
            if(minHeap.isEmpty()) {
                minHeap.offer(cur)
            } else {
                //Put large num to minHeap
                if(cur > minHeap.peek()) {
                    minHeap.offer(cur)
                } else {
                    maxHeap.offer(cur)
                }
            }

            //Ensure the minHeap and maxHeap size are the same or minHeap size - maxHeap size == 1
            if(minHeap.size > maxHeap.size + 1) {
                maxHeap.offer(minHeap.poll())
            } else if(maxHeap.size > minHeap.size){
                minHeap.offer(maxHeap.poll())
            }

            if(minHeap.size == maxHeap.size) {
                rtList.add(0.5 * (minHeap.peek() + maxHeap.peek()))
            } else {
                rtList.add(minHeap.peek().toDouble())
            }
        }

        return rtList
    }
}