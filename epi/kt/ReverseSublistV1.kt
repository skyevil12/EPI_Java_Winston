package epi.kt

import epi.ListNode

object ReverseSublistV1 {
//    fun reverseSublist(L: ListNode<Int>?, start: Int, finish: Int): ListNode<Int>? {
//        if(start == finish) {
//            return L
//        }
//
//        var dummy: ListNode<Int> = ListNode<Int>(0, L)
//        var prev = dummy
//
//        var i = 1
//        while(i++ < start) {
//            prev = prev.next
//        }
//
//        var iter = prev.next
//        var st = start
//        while(st++ < finish) {
//            var tmp = iter.next
//            iter.next = tmp.next
//            tmp.next = prev.next
//            prev.next = tmp
//        }
//
//        return dummy.next
//    }

    fun reverseSublist(L: ListNode<Int>?, start: Int, finish: Int): ListNode<Int>? {
        if(start == finish) {
            return L
        }

        var dummy = ListNode(-1, L)
        var prev = dummy

        var i = 0
        while(i < start - 1) {
            prev = prev.next
            i++
        }

        var st = prev.next
        var cur = st

        while(i < finish - 1) {
            cur = cur.next
            i++
        }

        var fNext = cur.next
        cur.next = null

        prev.next = reverseList(st)
        st.next = fNext
        return dummy.next
    }

    fun reverseList(L: ListNode<Int>?): ListNode<Int>? {
        var prev: ListNode<Int>? = null
        var cur = L

        while(cur != null) {
            var tmp = cur.next
            cur.next = prev
            prev = cur
            cur = tmp
        }

        return prev
    }
}