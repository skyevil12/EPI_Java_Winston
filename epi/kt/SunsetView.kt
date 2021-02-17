package epi.kt

import java.util.*
import kotlin.collections.ArrayList

object SunsetView {
    fun examineBuildingsWithSunset(sequence: Iterator<Int>) : List<Int> {
//        var dq: Deque<Array<Int>> = ArrayDeque()
//        var i = 0
//
//        while(sequence.hasNext()) {
//            val cur = sequence.next()
//            while(!dq.isEmpty() && dq.peekFirst()[1] <= cur) {
//                dq.pollFirst()
//            }
//
//            dq.offerFirst(arrayOf(i++, cur))
//        }
//
//        var rtList: MutableList<Int> = ArrayList()
//        while(!dq.isEmpty()) {
//            rtList.add(dq.pollFirst()[0])
//        }
//
//        return rtList
        var tmp: Deque<Int> = ArrayDeque()
        while(sequence.hasNext()) {
            tmp.offerFirst(sequence.next())
        }
        return examineBuildingsWithSunsetV1(tmp.iterator())
    }

    fun examineBuildingsWithSunsetV1(sequence: Iterator<Int>) : List<Int> {
        var dq = ArrayDeque<Array<Int>>()
        var i = 0

        while(sequence.hasNext()) {
            val cur = sequence.next()
            if(dq.isEmpty() || cur > dq.peekFirst()[1]) {
                dq.offerFirst(arrayOf(i, cur))
            }
            i++
        }

        var rtList: MutableList<Int> = ArrayList()
        while(!dq.isEmpty()) {
            rtList.add((i - 1) - dq.pollLast()[0])
        }

        return rtList
    }
}