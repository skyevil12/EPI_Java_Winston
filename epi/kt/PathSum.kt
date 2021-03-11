package epi.kt

import epi.BinaryTreeNode
import java.util.ArrayList

object PathSum {
    fun hasPathSum(tree: BinaryTreeNode<Int>?, remainingWeight: Int): Boolean {
        if(tree == null) {
            return false
        }

        val lWeight = remainingWeight - tree.data
        if(lWeight == 0 && tree.left == null && tree.right == null) {
            return true
        }

        return hasPathSum(tree.left, lWeight) || hasPathSum(tree.right, lWeight)
    }

    fun hasPathSumV1(tree: BinaryTreeNode<Int>?, remainingWeight: Int, list: List<Int>, rtList: MutableList<List<Int>>) {
        if(tree == null) {
            return
        }

        val nList: MutableList<Int> = ArrayList()
        nList.addAll(list)
        nList.add(tree.data)
        val lWeight = remainingWeight - tree.data
        if(lWeight == 0 && tree.left == null && tree.right == null) {
            rtList.add(nList)
        } else {
            hasPathSumV1(tree.left, lWeight, nList, rtList)
            hasPathSumV1(tree.right, lWeight, nList, rtList)
        }
    }
}