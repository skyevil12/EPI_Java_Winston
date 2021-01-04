package epi.kt

import epi.ListNode

object RemoveDuplicatesFromSortedList {
    /*
    2 2 3 5 7 11 11

     */
    fun removeDuplicates(L: ListNode<Int>?) : ListNode<Int>? {
        var cur = L
        while(cur != null) {
            var next = cur.next
            while(next != null && next.data == cur.data) {
                next = next.next
            }

            cur.next = next
            cur = cur.next
        }

        return L
    }
}