package epi.kt

import epi.BinaryTree
import java.util.*

object TreeFromPostorderWithNull {
    /*10.13 variant1, by the way
    inOrder generated list should not help to generate the original tree
    because we cannot know the right root position
     */
    fun reconstructPostorder(postorder: List<Int?>) : BinaryTree<Int>? {
        var stack = LinkedList<Int?>()
        for(e in postorder) {
            stack.push(e)
        }

        return core(stack)
    }

    private fun core(stack: Deque<Int?>) : BinaryTree<Int>? {
        //Could we remove this?
        if(stack.isEmpty()) {
            return null
        }

        val rVal = stack.pop() ?: return null
        val root = BinaryTree(rVal)
        root.right = core(stack)
        root.left = core(stack)
        return root
    }
}