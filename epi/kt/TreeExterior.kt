package epi.kt

import epi.BinaryTreeNode

object TreeExterior {
    //T O(N) S O(h + N(output))
    fun exteriorBinaryTree(tree: BinaryTreeNode<Int>?): List<BinaryTreeNode<Int>> {
        val rtList = mutableListOf<BinaryTreeNode<Int>>()
        if(tree == null) {
            return rtList
        }
        rtList.add(tree)
        coreL(tree.left, rtList, true)
        coreR(tree.right, rtList, true)

        return rtList
    }

    private fun coreL(node: BinaryTreeNode<Int>?, list: MutableList<BinaryTreeNode<Int>>, isBoundary: Boolean) {
        if(node == null) {
            return
        }

        if(isBoundary || (node.left == null && node.right == null )) {
            list.add(node)
        }

        coreL(node.left, list, isBoundary)
        coreL(node.right, list, isBoundary && node.left == null)
    }

    private fun coreR(node: BinaryTreeNode<Int>?, list: MutableList<BinaryTreeNode<Int>>, isBoundary: Boolean) {
        if(node == null) {
            return
        }

        coreR(node.left, list, isBoundary && node.right == null)
        coreR(node.right, list, isBoundary)

        if(isBoundary || (node.left == null && node.right == null )) {
            list.add(node)
        }
    }
}