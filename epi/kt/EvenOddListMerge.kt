package epi.kt

import epi.ListNode

object EvenOddListMerge {
    fun evenOddMerge(L: ListNode<Int>?) : ListNode<Int>? {
        if(L == null) {
            return null
        }

        var even = L
        var odd = even?.next
        val oH = odd

        while(true) {
            if(odd == null || odd.next == null) {
                even?.next = oH
                break
            }
            even?.next = odd.next
            even = even?.next
            odd.next = even?.next
            odd = odd.next
        }

        return L
    }

}