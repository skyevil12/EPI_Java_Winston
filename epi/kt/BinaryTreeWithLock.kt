package epi.kt

import epi.BinaryTreeNode

class BinaryTreeWithLock {
    //Use the lock child cnt to avoid traverse children every time
    class BinaryTreeNodeEx(var isLocked: Boolean, var parent: BinaryTreeNodeEx, var lockChCnt: Int) : BinaryTreeNode<Int>()

    fun isLocked(node : BinaryTreeNodeEx) : Boolean {
        return node.isLocked
    }

    fun lock(node : BinaryTreeNodeEx) : Boolean {
        if(node.isLocked) {
            return true
        }

        //Check if parent has lock, true return false
        if(!isWritable(node)) {
            return false
        }

        node.isLocked = true
        var parent = node.parent
        while(parent != null) {
            parent.lockChCnt++
            parent = parent.parent
        }

        return true
    }

    fun unlock(node : BinaryTreeNodeEx) : Boolean {
        if(!node.isLocked) {
            return true
        }

        //If the ancestors or children are lock we cannot do anything
        if(!isWritable(node)) {
            return false
        }

        node.isLocked = false
        var parent = node.parent
        while(parent != null) {
            parent.lockChCnt--
            parent = parent.parent
        }

        return true
    }

    private fun isWritable(node : BinaryTreeNodeEx) : Boolean {
        //Only for children
        if(node.lockChCnt > 0) {
            return false
        }

        var parent = node.parent
        while(parent != null) {
            if(parent.isLocked) {
                return false
            }

            parent = parent.parent
        }

        return true
    }
}