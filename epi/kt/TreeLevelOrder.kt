package epi.kt

import epi.BinaryTreeNode
import java.util.*
import kotlin.collections.ArrayList

object TreeLevelOrder {
    fun binaryTreeDepthOrder(tree: BinaryTreeNode<Int>?) : List<List<Int>> {
        var q1: Queue<BinaryTreeNode<Int>> = ArrayDeque()
        var rtList: MutableList<MutableList<Int>> = ArrayList()
        //Variant3
        var avgList: MutableList<Double> = ArrayList()
        if(tree == null) {
            return rtList
        }
        q1.offer(tree)
        while(!q1.isEmpty()) {
            var q2: Queue<BinaryTreeNode<Int>> = ArrayDeque()
            var list: MutableList<Int> = ArrayList()
            var sum = 0.0
            while(!q1.isEmpty()) {
                var cur = q1.poll()
                list.add(cur.data)
                sum += cur.data
                if(cur.left != null) {
                    q2.offer(cur.left)
                }

                if(cur.right != null) {
                    q2.offer(cur.right)
                }
            }
            q1 = q2
            rtList.add(list)
            val avg = sum / list.size
//            System.out.println("AVG = $avg")
            avgList.add(avg)
        }

        return rtList
    }

    //Variant1 -> Leetcode 103, https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

    //Variant2 -> Reverse original output list would be okay

    //Variant -> comment in source code
}