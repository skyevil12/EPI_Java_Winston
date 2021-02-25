package epi.kt

import epi.BinaryTreeNode

object IsTreeBalancedV1 {
    //https://www.geeksforgeeks.org/find-the-largest-complete-subtree-in-a-given-binary-tree/
    /*
        Example java
        // Structure for return type of
        // function findPerfectBinaryTree
        static class returnType
        {

            // To store if sub-tree is perfect or not
            boolean isPerfect;

            // To store if sub-tree is complete or not
            boolean isComplete;

            // size of the tree
            int size;

            // Root of biggest complete sub-tree
            node rootTree;
        };

        // helper function that returns height
        // of the tree given size
        static int getHeight(int size)
        {
            //Secure that no 
            return (int)Math.ceil(Math.log(size + 1) / Math.log(2));
        }

        // Function to return the biggest
        // complete binary sub-tree
        static returnType findCompleteBinaryTree(node root)
        {
                returnType rt = new returnType();
                if(root == null) {
                    rt.isPerfect = true;
                    rt.isComplete = true;
                    rt.size = 0;
                    rt.rootTree = null;
                    return rt;
                }

                returnType lRt = findCompleteBinaryTree(root.left);
                returnType rRt = findCompleteBinaryTree(root.right);

                if(lRt.isPerfect && rRt.isComplete && getHeight(lRt.size) == getHeight(rRt.size)) {
                    rt.isPerfect = rRt.isPerfect;
                    rt.isComplete = true;
                    rt.size = lRt.size + rRt.size + 1;
                    rt.rootTree = root;
                    return rt;
                } else if(lRt.isComplete && rRt.isPerfect && getHeight(lRt.size) - getHeight(rRt.size) == 1) {
                    rt.isPerfect = false;
                    rt.isComplete = true;
                    rt.size = lRt.size + rRt.size + 1;
                    rt.rootTree = root;
                    return rt;
                } else {
                    rt.isPerfect = false;
                    rt.isComplete = false;
                    rt.size = Math.max(lRt.size, rRt.size);
                    rt.rootTree = lRt.size > rRt.size ? lRt.rootTree : rRt.rootTree;
                    return rt;
                }
        }
     */
}