package epi.kt

object SearchEntryEqualToIndex {
    fun searchEntryEqualToItsIndex(A: List<Int>) : Int {
        var l = 0
        var r = A.size - 1

        while(l <= r) {
            var m = l + (r - l) / 2
            when {
                A[m] == m -> {
                    return m
                }
                A[m] > m -> {
                    r = m - 1
                }
                else -> {
                    //A[m] < m
                    l = m + 1
                }
            }
        }

        return -1
    }
}