package epi.kt

import epi.BinaryTreeNode

object IsTreeBalancedV2 {
    fun findNonKBalancedParent(node : BinaryTreeNode<Int>?, k : Int) : BinaryTreeNode<Int> {
        val rt = arrayOf(BinaryTreeNode<Int>())
        core(node, k, rt)
        return rt[0]
    }

    fun core(node : BinaryTreeNode<Int>?, k : Int, rt : Array<BinaryTreeNode<Int>>) : Int {
        if(node == null) {
            return 0
        }

        val lCnt = core(node.left, k, rt)
        if(lCnt < 0) {
            return lCnt
        }
        val rCnt = core(node.right, k, rt)
        if(rCnt < 0) {
            return rCnt
        }

        if(Math.abs(lCnt - rCnt) > k) {
            rt[0] = node
            return -1
        }

        return 1 + lCnt + rCnt
    }
}

fun main() {
    val M = BinaryTreeNode(641)
    val N = BinaryTreeNode(257)
    val L = BinaryTreeNode(401, null, M)
    val H = BinaryTreeNode(17)
    val P = BinaryTreeNode(28)
    val K = BinaryTreeNode(1, L, N)
    val G = BinaryTreeNode(3, H, null)
    val E = BinaryTreeNode(0)
    val D = BinaryTreeNode(28)
    val O = BinaryTreeNode(271, null, P)
    val J = BinaryTreeNode(2, null, K)
    val F = BinaryTreeNode(561, null, G)
    val C = BinaryTreeNode(271, D , E)
    val I = BinaryTreeNode(6, J, O)
    val B = BinaryTreeNode(6, C, F)
    val A = BinaryTreeNode(314, B, I)

    print("node data is ${IsTreeBalancedV2.findNonKBalancedParent(A, 3).data}")
}