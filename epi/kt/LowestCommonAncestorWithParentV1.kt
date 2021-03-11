package epi.kt

import epi.BinaryTree

object LowestCommonAncestorWithParentV1 {
    //T O(h(node0) + h(node1)), S O(Max(h(node0) + h(node1)))
    fun lca(node0: BinaryTree<Int>, node1: BinaryTree<Int>) : BinaryTree<Int> {
        val h0 = getHeight(node0)
        val h1 = getHeight(node1)

        var ln0 = node0
        var ln1 = node1
        if(h0 > h1) {
            var diff = h0 - h1
            while(diff > 0) {
                ln0 = ln0.parent
                diff--
            }
        } else if(h1 > h0) {
            var diff = h1 - h0
            while(diff > 0) {
                ln1 = ln1.parent
                diff--
            }
        }

        while(ln0 != ln1) {
            ln0 = ln0.parent
            ln1 = ln1.parent
        }

        return ln0
    }

    private fun getHeight(node: BinaryTree<Int>?) : Int {
        if(node == null) {
            return 0
        }

        return 1 + getHeight(node.parent)
    }
}