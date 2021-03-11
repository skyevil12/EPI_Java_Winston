package epi.kt

import epi.BinaryTreeNode

object LowestCommonAncestorV1 {
    fun lca(node: BinaryTreeNode<Int>?, node1: BinaryTreeNode<Int>, node2: BinaryTreeNode<Int>) : BinaryTreeNode<Int>? {
        if(node == null || node == node1 || node == node2) {
            return node
        }

        var l = lca(node.left, node1, node2)
        var r = lca(node.right, node1, node2)
        return if(l != null && r != null) {
            node
        } else {
            l ?: r
        }
    }
}