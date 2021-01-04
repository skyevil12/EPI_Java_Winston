package epi.kt

import epi.ListNode

object ListCyclicRightShift {
    /*
        T O(N) S O(1)
     */
    fun cyclicallyRightShiftList(L: ListNode<Int>?, k: Int) : ListNode<Int>? {
        if(L == null) {
            return null
        }
        var dummy = ListNode<Int>(-1, L)
        var tail = L
        var len = 1
        while(tail!!.next != null) {
            tail = tail.next
            len++
        }

        var lK = k
        lK %= len
        if(lK == 0) {
            return L
        }

        tail!!.next = L
        //Find new tail++
        var cnt = len - lK
        while(cnt > 0) {
            tail = tail!!.next
            cnt--
        }
        dummy.next = tail!!.next;
        tail.next = null
        //Find new tail--
        return dummy.next
    }
}