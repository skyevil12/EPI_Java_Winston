package epi.kt

import epi.ListNode

object RemoveDuplicatesFromSortedListV1 {
    /*
        Input: head = [1,2,3,3,4,4,5] 2
        Output: [1,2,3,3,4,4,5]
        Leetcode 82
     */
    fun removeDuplicates(L: ListNode<Int>?, m: Int) : ListNode<Int>? {
        var dummy = ListNode<Int>(-1, L)
        var rt = dummy
        var cur = L
        while(cur != null) {
            var next = cur.next
            var cnt = 1
            while(next != null && next.data == cur.data) {
                next = next.next
                cnt++
            }

            if(cnt <= m) {
                rt.next = cur
                while(rt.next != next) {
                    rt = rt.next
                }
            }
            cur = next
        }
        rt.next = null
        return dummy.next
    }
}

fun main() {
    var test = arrayOf(1, 1, 2, 3, 4, 5)
    var node = ListNode<Int>(-1, null)
    var cur = node
    for(num in test.iterator()) {
        cur.next = ListNode<Int>(num, null)
        cur = cur.next
    }

    var rt = RemoveDuplicatesFromSortedListV1.removeDuplicates(node.next, 1)
    if(rt == null) {
        print("Empty!");
        return
    }

    for(num in rt!!.toArray()!!.iterator()) {
        print(num)
        print(',')
    }
}