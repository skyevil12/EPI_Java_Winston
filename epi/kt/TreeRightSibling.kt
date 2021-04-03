package epi.kt

import epi.TreeRightSibling

object TreeRightSibling {
    //T O(N)    S O(h)
    fun constructRightSibling(tree: TreeRightSibling.BinaryTreeNode<Int>?) {
        preorder(tree)
    }

    private fun preorder(tree: TreeRightSibling.BinaryTreeNode<Int>?) {
        if(tree == null) {
            return
        }

        if(tree.left != null) {
            tree.left.next = tree.right
        }

        if(tree.right != null && tree.next != null) {
            tree.right.next = tree.next.left
        }

        preorder(tree.left)
        preorder(tree.right)
    }
}