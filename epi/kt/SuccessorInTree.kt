package epi.kt

import epi.BinaryTree

object SuccessorInTree {
    //T O(h)    S O(1)
    fun findSuccessor(node: BinaryTree<Int>) : BinaryTree<Int>? {
//        if(node == null) {
//            return null
//        }
//
//        var rNode = node.right
//        if(rNode != null) {
//            var rt = rNode
//            while (rNode != null) {
//                rt = rNode
//                rNode = rNode.left
//            }
//            return rt
//        }
//
//        var cur = node
//        var parent = cur.parent
//        while(parent != null && cur != parent.left) {
//            cur = parent
//            parent = parent.parent
//        }
//
//        return parent
        if(node.right != null) {
            var cur = node.right
            while(cur.left != null) {
                cur = cur.left
            }
            return cur
        }

        var rt = node
        while(rt.parent != null && rt == rt.parent.right) {
            rt = rt.parent
        }

        return rt.parent
    }
}