package epi.kt

object TreeRightSiblingV1 {
    /*
        https://www.techiedelight.com/convert-normal-binary-tree-left-child-right-sibling-binary-tree/
        The idea is quite simple
        Post order to handle below two cases
        1. if root.left == null, root.left = root.right
        2. root.left.right = root.right and root.right = null
        After modified tree, then connect level
     */
}

/*
    // A class to store a binary tree node
class Node
{
    int key;
    Node left = null, right = null;

    Node(int key) {
        this.key = key;
    }
}

class PlayGround
{
    // Function to perform preorder traversal on a given binary tree.
    public static void preorder(Node root)
    {
        if (root == null) {
            return;
        }

        System.out.print(root.key + " ");
        if(root.right != null) {
            System.out.println("root.right val " + root.right.key);
        }
        preorder(root.left);
        preorder(root.right);
    }


    // Function to convert a normal binary tree into a Left–child
    // right–sibling (LC–RS) binary tree
    public static void convert(Node root)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }

        // recursively convert the left and right subtree first
        convert(root.left);
        convert(root.right);

        // if the left child is empty, point it to the right child
        // and set the right child to null
        if (root.left == null)
        {
            root.left = root.right;
            root.right = null;
        }

        // if the left child already exists, then make its right child
        // point to the current node's right child and
        // and set the right child as null
        else {
            root.left.right = root.right;
            root.right = null;
        }
    }

    private static void connectLevels(Node node) {
        if(node == null || node.left == null) {
            return;
        }

        Node btn = node;
        while(btn != null) {
            if(btn.left != null && btn.left.right != null && btn.right != null) {
                btn.left.right.right = btn.right.left;
            }
            btn = btn.right;
        }

        connectLevels(node.left);
    }

    public static void main(String[] args)
    {
        /* Construct the following tree
                  1
                /  \
               /    \
              2      3
             / \    /
            4   5  6
                  / \
                 7   8
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        convert(root);
        connectLevels(root.left);
        preorder(root);
    }
}
 */