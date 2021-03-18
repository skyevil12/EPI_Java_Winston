package epi.kt

import epi.BinaryTreeNode
import java.util.ArrayDeque

object TreePreorder {
    //T O(N) S O(h)
    fun preorderTraversal(tree : BinaryTreeNode<Int>?) : List<Int> {
        var rtList = ArrayList<Int>()

        var stack = ArrayDeque<BinaryTreeNode<Int>>()
        var tmp = tree

        //left -> root -> right
        while(!stack.isEmpty() || tmp != null) {
            while(tmp != null) {
                rtList.add(tmp.data)
                stack.push(tmp)
                tmp = tmp.left
            }

            val node = stack.pop()
            tmp = node.right
        }

        return rtList
    }
}