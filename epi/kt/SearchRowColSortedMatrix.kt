package epi.kt

object SearchRowColSortedMatrix {
    fun matrixSearch(A: List<List<Int>>, x: Int) : Boolean {
        //T O(M + N) S O(1)
        //Start from top/right
        val m = A.size
        val n = A[0].size

        var i = 0
        var j = n - 1

        while(i < m && j >= 0) {
            val cur = A[i][j]
            when {
                cur == x -> {
                    return true
                }
                cur > x -> {
                    j--
                }
                cur < x -> {
                    i++
                }
            }
        }

        return false
    }
}