package epi.kt

import epi.BinaryTree

object SuccessorInTree {
    fun findSuccessor(node: BinaryTree<Int>) : BinaryTree<Int>? {
        //T O(h) S O(1)
        if(node.right != null) {
            //Find left most of the right node
            var cur = node.right
            while(cur.left != null) {
                cur = cur.left
            }
            return cur
        }

        var cur = node
        while(cur.parent != null && cur === cur.parent.right) {
            cur = cur.parent
        }

        return cur.parent
    }
}