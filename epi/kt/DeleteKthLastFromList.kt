package epi.kt

import epi.ListNode

object DeleteKthLastFromList {
    fun removeKthLast(L: ListNode<Int>, k: Int) : ListNode<Int>? {
        var dummy = ListNode<Int>(-1, L)
        var tail = dummy
        var prev = dummy
        var cnt = 0
        while(cnt < k) {
            tail = tail.next
            cnt++
        }

        while(tail.next != null) {
            tail = tail.next
            prev = prev.next
        }

        var delNode = prev.next
        prev.next = delNode.next
        //Redundant
        delNode.next = null
        return dummy.next
    }
}