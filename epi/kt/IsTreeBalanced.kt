package epi.kt

import epi.BinaryTreeNode

object IsTreeBalanced {
    fun isBalanced(tree : BinaryTreeNode<Int>?) : Boolean {
        return core(tree) >= 0
    }

    fun core(node : BinaryTreeNode<Int>?) : Int {
        if(node == null) {
            return 0
        }

        val lH = core(node.left)
        if(lH < 0) {
            return lH
        }
        val rH = core(node.right)
        if(rH < 0) {
            return rH
        }

        if(Math.abs(lH - rH) > 1) {
            return -1
        }

        return 1 + Math.max(lH, rH)
    }
}