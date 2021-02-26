package epi.kt

class SearchEntryEqualToIndexV1 {
    //FIXME: There is bug inside!!
    fun searchEntryEqualToItsIndex(A: Array<Int>) : Int {
        //A: Brute force one pass to solve this
        //B: Binary search to find index and
        // another binary search for repetition start/end index
        var l = 0
        var r = A.size - 1

        while(l <= r) {
            val m = l + (r - l) / 2
            val cur = A[m]
            if(cur == m) {
                return m
            } else {
                if((m + 1 < A.size && A[m] == A[m + 1])
                        || (m - 1 >= 0 && A[m - 1] == A[m])) {
                            println("Repetition occurs!")
                    val ed = bsLarger(A, cur, m, r) - 1
                    val st = bsSmaller(A, cur, l, m)
                    if(m in st..ed) {
                        return m
                    }
                } else if(cur < m){
                    l = m + 1
                } else if(cur > m) {
                    r = m - 1
                }
            }
        }

        return -1
    }

    private fun bsLarger(A: Array<Int>, st: Int, ed: Int, K : Int) : Int {
        var l = st
        var r = ed + 1

        while(l < r) {
            val m = l + (r - l) / 2
            if(A[m] > K) {
                r = m
            } else {
                l = m + 1
            }
        }

        return l
    }

    private fun bsSmaller(A: Array<Int>, st: Int, ed: Int, K : Int) : Int {
        var l = st
        var r = ed + 1

        while(l < r) {
            val m = l + (r - l) / 2
            if(A[m] > K) {
                r = m - 1
            } else if(A[m] < K){
                l = m + 1
            } else {
                r = m
            }
        }

        return l
    }
}

fun main() {
    var a = arrayOf(-2,0, 4,4, 4,7,9)
    println("Solution would be ${SearchEntryEqualToIndexV1().searchEntryEqualToItsIndex(a)}")
}