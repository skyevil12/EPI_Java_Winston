package epi.kt

import epi.BinaryTree

object LowestCommonAncestorCloseAncestor {
    fun lca(node0: BinaryTree<Int>?, node1: BinaryTree<Int>?) : BinaryTree<Int>? {
        var lNode0 = node0
        var lNode1 = node1
        val set = HashSet<BinaryTree<Int>>()

        while(lNode0 != null || lNode1 != null) {
            if(lNode0 != null) {
                if (!set.add(lNode0)) {
                    return lNode0
                }
                lNode0 = lNode0.parent
            }

            if(lNode1 != null) {
                if (!set.add(lNode1)) {
                    return lNode1
                }
                lNode1 = lNode1.parent
            }
        }

        return null
    }
}