package epi.kt

import epi.BinaryTree
import java.util.ArrayList

object TreeWithParentInorder {
    fun postorderTraversal(tree: BinaryTree<Int>?) : List<Int> {
        var rtList = mutableListOf<Int>()
        if(tree == null) {
            return rtList
        }

        /*
            1
           2 3

           2 3 1
         */
        var cur = tree
        while(cur != null) {
            rtList.add(0, cur!!.data)
            while(cur?.right != null) {
                cur = cur.right
                rtList.add(0, cur!!.data)
            }

            while(cur != null) {
                if (cur.left != null) {
                    cur = cur.left
                    break
                } else if (cur.parent != null && cur === cur.parent.left) {
                    while (cur?.parent != null && cur === cur.parent.left) {
                        cur = cur.parent
                    }
                }
                cur = cur?.parent
            }
        }

        return rtList
    }
    fun preorderTraversal(tree: BinaryTree<Int>?) : List<Int> {
        var rtList = mutableListOf<Int>()
        if(tree == null) {
            return rtList
        }

        var cur = tree
        while(cur != null) {
            rtList.add(cur.data)
            while(cur?.left != null) {
                cur = cur.left
                rtList.add(cur.data)
            }

            while(cur != null) {
                if (cur.right != null) {
                    cur = cur.right
                    break
                } else if (cur.parent != null && cur === cur.parent.right) {
                    while (cur?.parent != null && cur === cur.parent.right) {
                        cur = cur.parent
                    }
                }
                cur = cur?.parent
            }
        }

        return rtList
    }
    fun inorderTraversal(tree: BinaryTree<Int>?) : List<Int> {
        //T O(N) S O(1)
        var rtList = ArrayList<Int>()
        if(tree == null) {
            return rtList
        }
        //Left, root, right
        var cur = tree

        while(cur != null) {
            while (cur!!.left != null) {
                cur = cur.left
            }

            while(cur != null) {
                rtList.add(cur.data)
                if (cur.right != null) {
                    cur = cur.right
                    break
                } else if(cur.parent != null && (cur === cur.parent.right)){
                    while(cur?.parent != null && (cur === cur.parent.right)) {
                        cur = cur.parent
                    }
                }

                cur = cur?.parent
            }
        }

        return rtList
    }
}