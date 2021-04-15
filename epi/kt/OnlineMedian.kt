package epi.kt

import java.util.*
import kotlin.math.min

object OnlineMedian {
    fun onlineMedian(sequence : Iterator<Int>) : List<Double> {
        val min = PriorityQueue<Int>()
        val max = PriorityQueue<Int>(Collections.reverseOrder())

        val rtList = mutableListOf<Double>()
        while(sequence.hasNext()) {
            val num = sequence.next()
            if(max.isEmpty() || num <= max.peek()) {
                max.offer(num)
            } else if(num > max.peek()) {
                min.offer(num)
            }

            if(max.size > min.size + 1) {
                min.offer(max.poll())
            } else if(max.size < min.size){
                max.offer(min.poll())
            }

            var med = if(max.size > min.size) {
                max.peek().toDouble()
            } else {
                0.5 * (max.peek() + min.peek())
            }
            rtList.add(med)
        }

        return rtList
    }
}