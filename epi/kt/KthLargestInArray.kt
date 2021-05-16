package epi.kt

import java.lang.RuntimeException
import java.util.*

object KthLargestInArray {
    fun findKthLargestStable(k : Int, A : MutableList<Int>) : Int {
        //Use merge sort directly
        mergeSort(A, 0, A.size - 1)
        return A[A.size - k]
    }

    private fun mergeSort(A : MutableList<Int>, l : Int, r : Int) {
        if(l < r) {
            val m = l + (r - l) / 2
            mergeSort(A, l, m)
            mergeSort(A, m + 1, r)
            merge(A, l, m , r)
        }
    }

    private fun merge(A: MutableList<Int>, l : Int, m : Int, r : Int) {
        val left = ArrayList(A.subList(l, m + 1))
        val right = ArrayList(A.subList(m + 1, r + 1))

        var i = l//Extreme important!!
        var lI = 0
        var rI = 0

        while(lI < left.size && rI < right.size) {
            if(left[lI] < right[rI]) {
                A[i++] = left[lI++]
            } else {
                A[i++] = right[rI++]
            }
        }

        while(rI < right.size) {
            A[i++] = right[rI++]
        }

        while(lI < left.size) {
            A[i++] = left[lI++]
        }
    }

    fun findMedian(A : List<Int>) : Int {
        if(A.size % 2 == 0) {
            //med = A[A.size / 2] + A[A.size / 2 - 1] / 2
        }

        throw RuntimeException("Not impl!")
    }
    /*
        3 2 1 5 4
        3
     */
    fun findKthLargest(k : Int, A : List<Int>) : Int {
        //Return val
        val list: MutableList<Int> = ArrayList()
        //T O(A) S O(A)
        for(i in A.indices) {
            list.add(A[i])
        }

        var pivot = -1
        var st = 0
        var ed = list.size - 1
        var lK = k - 1
        //T O(logA) S O(A)
        while(true) {
            val ranIdx = Random().nextInt(ed - st + 1) + st
            Collections.swap(list, ranIdx, ed)
            pivot = partition(list, st, ed)
            if(pivot == lK) {
                break
            } else if(pivot < lK) {
                st = pivot + 1
            } else {
                ed = pivot - 1
            }
        }

        return list[pivot]
    }

    private fun partition(list : MutableList<Int>, st : Int, ed : Int) : Int {
        val target = list[ed]
        var idx = st - 1

        for(i in st until ed) {
            if(list[i] > target) {
                Collections.swap(list, ++idx, i)
            }
        }

        Collections.swap(list, idx + 1, ed)
        return idx + 1
    }
}