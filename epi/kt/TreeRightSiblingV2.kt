package epi.kt

import epi.TreeRightSibling

class TreeRightSiblingV2 {
    fun constructRightSibling(tree: TreeRightSibling.BinaryTreeNode<Int>?) {
        //Constant space for non perfect binary tree
        var nStart = tree

        while(nStart != null) {
            var cNSt: TreeRightSibling.BinaryTreeNode<Int>? = null
            var cur = nStart
            var prev: TreeRightSibling.BinaryTreeNode<Int>? = null
            while(cur != null) {
                if(cur.left != null) {
                    if(cNSt == null) {
                        cNSt = cur.left
                    }
                    if(prev != null) {
                        prev.next = cur.left
                    }
                    prev = cur.left
                }

                if(cur.right != null) {
                    if(cNSt == null) {
                        cNSt = cur.right
                    }
                    if(prev != null) {
                        prev.next = cur.right
                    }
                    prev = cur.right
                }

                cur = cur.next
            }

            nStart = cNSt
        }
    }
}