package epi.kt

object SearchFirstKey {
    fun searchFirstOfKV1(A: Array<Int>?, k: Int) : Int {
        if(A == null || A.isEmpty()) {
            return -1
        }

        var l = 0
        var r = A.size

        while(l < r) {
            var m = l + (r - l) / 2
            var cur = A[m]
            if(cur <= k) {
                l = m + 1
            } else {
                r = m
            }
        }

        return if(l < A.size) {
            l
        } else {
            -1
        }
    }

    fun searchFirstOfKV2(A: Array<Int>?) : Int {
        if(A == null) {
            return -1
        }

        val len = A.size
        var l = 1
        var r = len - 2

        while(l < r) {
            val m = l + (r - l) / 2
            if(A[m] < A[m + 1]) {
                r = m
            } else {
                l = m + 1
            }
        }

        return l
    }

    fun searchFirstOfKV3(A: Array<Int>?, k: Int) : Array<Int> {
        if(A == null || A.isEmpty()) {
            return arrayOf(-1, -1)
        }

        var l = 0
        var r = A.size - 1
        //Lower bound
        while(l < r) {
            var m = l + (r - l) / 2
            val cur = A[m]
            when {
                cur > k -> {
                    r = m - 1
                }
                cur == k -> {
                    r = m
                }
                else -> {
                    l = m + 1
                }
            }
        }

        if(A[l] != k) {
            return arrayOf(-1, -1)
        }
        val st = l
        //Upper bound
        l = 0
        r = A.size
        while(l < r) {
            var m = l + (r - l) / 2
            val cur = A[m]
            if(cur <= k) {
                l = m + 1
            } else {
                r = m
            }
        }

        return arrayOf(st, l - 1)
    }

    fun searchFirstOfKV4(strArray : Array<String>, p : String) : Boolean {
        var l = 0
        var r = strArray.size

        while(l < r) {
            var m = l + (r - l) / 2
            var str = strArray[m]
            if(str.startsWith(p)) {
                return true
            } else if(str < p) {
                l = m + 1;
            } else if(str > p) {
                r = m - 1;
            }
        }

        return false
    }
}

fun main() {
//    var A = arrayOf<Int>(-14, -10, 2, 108, 108, 243, 285, 285, 285, 401)
//    print("found idx = ${SearchFirstKey.searchFirstOfKV1(A, 285)}")

    var B = arrayOf<Int>(2, 1, 5, 5)
    print("found idx = ${SearchFirstKey.searchFirstOfKV2(B)}")

//    var A = arrayOf<Int>(1, 2, 2, 4, 4, 4, 7, 11, 11, 13)
//    print("found region = {${SearchFirstKey.searchFirstOfKV3(A, 13)[0]}, ${SearchFirstKey.searchFirstOfKV3(A, 13)[1]}}")

//    var strArray = arrayOf("aaaa", "bbbb", "cccc", "dddd")
//    println("found = ${SearchFirstKey.searchFirstOfKV4(strArray, "cc")}")
//    println("found = ${SearchFirstKey.searchFirstOfKV4(strArray, "qq")}")
}