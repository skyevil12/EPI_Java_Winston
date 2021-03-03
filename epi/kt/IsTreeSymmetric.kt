package epi.kt

import epi.BinaryTreeNode

object IsTreeSymmetric {
    fun isSymmetric(tree : BinaryTreeNode<Int>?) : Boolean {
        if(tree == null) {
            return true
        }
        return core(tree.left, tree.right)
    }

    fun core(l: BinaryTreeNode<Int>?, r: BinaryTreeNode<Int>?) : Boolean {
        if(l == null && r == null) {
            return true
        } else if(l == null || r == null) {
            return false
        }

        if(l.data != r.data) {
            return false
        }
        return core(l.left, r.right) && core(l.right, r.left)
    }
}