package epi.kt

import epi.BinaryTreeNode
import java.util.*

class TreeFromPreorderWithNull {
    fun reconstructPreorder(preorder: List<Int?>) : BinaryTreeNode<Int>? {
        val q = LinkedList<Int?>()
        for(e in preorder) {
            q.offer(e)
        }

        return core(q)
    }

    fun core(q : Queue<Int?>) : BinaryTreeNode<Int>? {
//        if(q.isEmpty()) {
//            return null;
//        }
        val rVal = q.poll() ?: return null

        val node = BinaryTreeNode(rVal)
        node.left = core(q)
        node.right = core(q)
        return node
    }
}