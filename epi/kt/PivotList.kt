package epi.kt

import epi.ListNode

object PivotList {
    //T O(N) S O(1)
    fun listPivoting(L: ListNode<Int>?, k: Int): ListNode<Int>? {
        if (L == null) {
            return null
        }
        /*
            sD, sI = sD, sl.next = cur, sl = sl.next
            eD, eI
            lD, li

            cur L
            while(cur != null) {

}

//12 4 56 k 4
//4 56
li.next = null
el.next = lD.next// equal large
sl.next = eD.next// link small equal

sD.next
*/
        var sD: ListNode<Int>? = ListNode(0, null)
        var sI = sD
        var eD: ListNode<Int>? = ListNode(0, null)
        var eI = eD
        var lD: ListNode<Int>? = ListNode(0, null)
        var li = lD
        var cur = L

        while (cur != null) {
            val data = cur.data
            if (data < k) {
                sI?.next = cur
                sI = sI?.next
            } else if (data == k) {
                eI?.next = cur
                eI = eI?.next
            } else {
                li?.next = cur
                li = li?.next
            }
            cur = cur.next
        }

        li?.next = null
        eI?.next = lD?.next
        sI?.next = eD?.next

        return sD?.next
    }
}
