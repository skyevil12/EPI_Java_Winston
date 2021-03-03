package epi.kt

import epi.BinaryTreeNode

object LowestCommonAncestor {
    //T O(N) S O(h)
    fun lca(tree: BinaryTreeNode<Int>?, node0: BinaryTreeNode<Int>?, node1: BinaryTreeNode<Int>?) : BinaryTreeNode<Int>? {
        if(tree == null) {
            return null
        } else if(tree == node0 || tree == node1) {
            return tree
        }

        var l = lca(tree.left, node0, node1)
        var r = lca(tree.right, node0, node1)

        return if(l != null && r != null) {
            tree
        } else if(l != null) {
            l
        } else if(r != null) {
            r
        } else {
            null
        }
    }
}