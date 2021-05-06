package epi.kt

import epi.SearchForMinMaxInArray

object SearchForMinMaxInArray {
    fun findMinMax(A: List<Int>) : SearchForMinMaxInArray.MinMax {
        var prev = SearchForMinMaxInArray.MinMax.minMax(A[0], A[0])
        for(i in 0 .. A.size - 2 step 2) {
            val cur = SearchForMinMaxInArray.MinMax.minMax(A[i], A[i + 1])
            prev = SearchForMinMaxInArray.MinMax(Math.min(cur.smallest, prev.smallest), Math.max(cur.largest, prev.largest))
        }

        if(A.size % 2 != 0) {
            val tail = A[A.size - 1];
            if(tail < prev.smallest) {
                prev.smallest = tail
            } else if(tail > prev.largest) {
                prev.largest = tail
            }
        }
        return prev
    }
}