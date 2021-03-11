package epi.kt

import epi.BinaryTreeNode

object SumRootToLeaf {
    fun sumRootToLeaf(tree: BinaryTreeNode<Int>?): Int {
        val rt = arrayOf(0)
        core(tree, 0, rt)
        return rt[0]
    }

    fun core(node: BinaryTreeNode<Int>?, sum: Int, rt: Array<Int>) {
        if(node == null) {
            return
        }

        var lSum = sum
        lSum += node.data

        if(node.left == null && node.right == null) {
            rt[0] += lSum
        } else {
            core(node.left, lSum * 2, rt)
            core(node.right, lSum * 2, rt)
        }
    }
}