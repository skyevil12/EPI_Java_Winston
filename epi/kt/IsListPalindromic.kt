package epi.kt

import epi.ListNode

object IsListPalindromic {
    fun isLinkedListAPalindrome(L: ListNode<Int>?): Boolean {
        if(L == null) {
            return true
        }

        var slow = L
        var fast = L

        while(fast?.next != null) {
            slow = slow?.next
            fast = fast.next.next
        }

        var tail = reverse(slow?.next)
        var cur = L
        while(tail != null) {
            if(tail.data != cur?.data) {
                return false
            }

            tail = tail.next
            cur = cur?.next
        }

        return true
    }

    fun reverse(L: ListNode<Int>?): ListNode<Int>? {
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