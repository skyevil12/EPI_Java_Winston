package epi.kt

import epi.BinaryTreeNode

object TreeFromPreorderInorder {
    fun binaryTreeFromPreorderInorder(preOrder: List<Int>, inOrder: List<Int>) : BinaryTreeNode<Int>? {
        //preOrder first is root, inOrder first is left most
        val inMap = HashMap<Int, Int>()
        for(i in inOrder.indices) {
            inMap[inOrder[i]] =  i
        }
        return core(inMap, preOrder, 0, preOrder.size - 1, inOrder, 0, inOrder.size - 1)
    }

    fun core(inMap: Map<Int, Int>, preOrder: List<Int>, pSt: Int, pEd: Int, inOrder: List<Int>, iSt: Int, iEd: Int) : BinaryTreeNode<Int>? {
        if(pSt > pEd || iSt > iEd) {
            return null
        }
        val nData = preOrder[pSt]
        var node = BinaryTreeNode(nData)
        var nIdx: Int = inMap[nData]!!
        //Use Map instead of searching it every time
//        for(i in iSt..iEd) {
//            if(inOrder[i] == nData) {
//                nIdx = i
//                break
//            }
//        }
        node.left = core(inMap, preOrder, pSt + 1, pSt + 1 + nIdx - 1 - iSt + 1 - 1, inOrder, iSt, nIdx - 1)
        node.right = core(inMap, preOrder, pSt + 1 + nIdx - 1 - iSt + 1, pEd, inOrder, nIdx + 1, iEd)
        return node
    }
}