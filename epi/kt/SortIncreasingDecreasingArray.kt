package epi.kt

import epi.SortedArraysMerge
import java.util.*

object SortIncreasingDecreasingArray {
    fun sortKIncreasingDecreasingArray(A: List<Int>): List<Int> {
        val rtList = mutableListOf<List<Int>>()
        var st = 0
        var isIncreasing = true

        //Be careful, this only start from 1 and must include A.size
        for(i in 1 .. A.size) {
            if(i == A.size
                    || (A[i - 1] > A[i] && isIncreasing)
                    || (A[i - 1] < A[i] && !isIncreasing)) {
                val l = A.subList(st, i)
                if(!isIncreasing) {
                    Collections.reverse(l)
                }
                rtList.add(l)
                isIncreasing = !isIncreasing
                st = i
            }
        }

        return SortedArraysMerge.mergeSortedArrays(rtList)
    }
}