package epi.kt

import epi.ListNode

object IsListCyclic {
    /*
        https://leetcode.com/problems/linked-list-cycle-ii/solution/
     */
    fun hasCycle(head: ListNode<Integer>?): ListNode<Integer>? {
        var slow: ListNode<Integer>? = head
        var fast: ListNode<Integer>? = head

        while(fast?.next != null) {
            slow = slow!!.next
            fast = fast!!.next.next
            if(slow === fast) {
                //F + a == nC, F = C - a
                var inter = slow
                var nHead = head
                while(nHead != inter) {
                    nHead = nHead?.next
                    inter = inter!!.next
                }

                return inter
            }
        }

        return null
    }
}