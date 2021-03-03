package epi.kt

import epi.BinaryTree

object LowestCommonAncestorWithParent {
    /*
        T O(N)  S O(h)
     */
    fun lca(node0: BinaryTree<Int>?, node1: BinaryTree<Int>?) : BinaryTree<Int>? {
        if(node0 == null || node1 == null) {
            return null
        }
        var ln0: BinaryTree<Int> = node0
        var ln1: BinaryTree<Int> = node1
        var dep0 = dep(node0)
        var dep1 = dep(node1)

        if(dep0 < dep1) {
            return lca(node1, node0)
        }

        while(dep0 - dep1 > 0) {
            ln0 = ln0.parent
            dep0--
        }

        while(ln0 != ln1) {
            ln0 = ln0.parent
            ln1 = ln1.parent
        }

        return ln0
    }

    private fun dep(node: BinaryTree<Int>?) : Int {
        if(node == null) {
            return 0
        }

        var rt = 0
        var cur = node
        while(cur != null) {
            cur = cur.parent
            rt++
        }

        return rt
    }
}