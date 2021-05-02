package epi.kt

class SearchEntryEqualToIndexV1 {
    fun searchEntryEqualToItsIndex(A: Array<Int>) : Int {
        var l = 0
        var r = A.size - 1

        while(l <= r) {
            var m = l + (r - l) / 2

            if(A[m] == m) {
                return m
            } else {
                if((m > 0 && A[m - 1] != A[m]) &&
                        (m + 1 < A.size && A[m] != A[m + 1])
                ) {
                    if(A[m] > m) {
                        r = m - 1
                    } else {
                        l = m + 1
                    }
                } else {
                    val st = bsLargerOrEqual(A, l, r + 1, A[m])
                    val ed = bsLarger(A, l, r + 1, A[m]) - 1
                    if(A[m] in st..ed) {
                        return A[m]
                    } else if(A[m] > ed) {
                        r = st - 1
                    } else {
                        //A[m] < st
                        l = ed + 1
                    }
                }
            }
        }

        return -1
    }

    private fun bsLarger(A: Array<Int>, st: Int, ed: Int, K : Int) : Int {
        var l = st
        var r = ed

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

    private fun bsLargerOrEqual(A: Array<Int>, st: Int, ed: Int, K : Int) : Int {
        var l = st
        var r = ed

        while(l < r) {
            val m = l + (r - l) / 2
            if(A[m] >= K) {
                r = m
            } else {
                //if(A[m] < K)
                l = m + 1
            }
        }

        return l
    }
}

fun main() {
//    var a = arrayOf(-2,0, 4,4, 4,7,9)
    var a = arrayOf(-2, -1, -1, -1, -1, 5)
    println("Solution would be ${SearchEntryEqualToIndexV1().searchEntryEqualToItsIndex(a)}")
}