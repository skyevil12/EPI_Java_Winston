package epi.kt

object SearchShiftedSortedArrayV1 {
    //https://leetcode.com/problems/peak-index-in-a-mountain-array/submissions/
    fun searchPeak(A : Array<Int>) : Int {
        /*
            if pivot >= right
            r = m
            pivot < right
            l = m + 1
         */
        var l = 0
        var r = A.size - 1

        while(l < r) {
            val m = l + (r - l) / 2
            val cur = A[m]

            if(m + 1 < A.size && cur > A[m + 1]) {
                r = m
            } else {
                l = m + 1
            }
        }

        return l
    }
}

fun main() {
    val a = arrayOf(1, 2, 3, 4, 5, 4, 3, 2, 1)
    print("peak index would be ${SearchShiftedSortedArrayV1.searchPeak(a)}")
}