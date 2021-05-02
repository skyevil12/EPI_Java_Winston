package epi.kt

class SearchShiftedSortedArray {
    fun searchSmallest(A: List<Int>) : Int {
        var l = 0
        var r = A.size - 1
        //Search smallest
//        if(A[l] < A[r]) {
//            return l
//        }

        /*
            arg0:     [3, 1, 2]
            l   0   1
            r   2   1
            m   1   0
         */
        while(l < r) {
            val m = l + (r - l) / 2
            if(A[m] >= A[l] && A[r] < A[l]) {
                l = m + 1
            } else {
                r = m
            }
            //Solution2
//            if(A[m] < A[r]) {
//                r = m
//            } else {
//                //A[m] >= A[r]
//                l = m + 1
//            }
        }

        return l
    }
}