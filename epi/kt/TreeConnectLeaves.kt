package epi.kt

import epi.BinaryTreeNode

object TreeConnectLeaves {
    fun createListOfLeaves(tree : BinaryTreeNode<Int>?) : List<BinaryTreeNode<Int>> {
        val rt: MutableList<BinaryTreeNode<Int>> = mutableListOf()
        dfs(tree, rt)
        return rt
    }

    //Try inorder/preorder/postorder: Any of them would be workable
    private fun dfs(node : BinaryTreeNode<Int>?, list : MutableList<BinaryTreeNode<Int>>) {
        if(node == null) {
            return
        }

        dfs(node.left, list)
        dfs(node.right, list)
        if(node.left == null && node.right == null) {
            list.add(node)
        }
    }
}