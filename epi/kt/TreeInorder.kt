package epi.kt

import epi.BinaryTreeNode
import java.util.ArrayDeque

object TreeInorder {
    //T O(N) S O(N) if skewed tree
    fun inorderTraversal(tree : BinaryTreeNode<Int>?) : List<Int> {
        var rt = ArrayList<Int>()
        var stack = ArrayDeque<BinaryTreeNode<Int>>()
        var tmp: BinaryTreeNode<Int>? = tree

        while(tmp != null || stack.isNotEmpty()) {
            while (tmp != null) {
                stack.push(tmp)
                tmp = tmp.left
            }

            val node = stack.pop()
            rt.add(node.data)
            tmp = node.right
        }

        return rt
    }
}