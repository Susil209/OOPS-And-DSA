package com.java.DSAQuestions.BinarySearchTree.AVLTree;

import static com.java.DSAQuestions.BinarySearchTree.AVLTree.CreateAVLTree.*;

public class DeleteAVLTree {
    public static void main(String[] args) {
        CreateAVLTree avl = new CreateAVLTree();
        
        Node root = null;

        avl.insert(4);
        avl.insert(2);
        avl.insert(6);
        avl.insert(1);
        avl.insert(3);
        avl.insert(5);
        avl.insert(7);

        System.out.println("Inorder traversal of the "
                + "constructed AVL tree is:");

        avl.inorder(avl.getRoot());

        deleteNode(avl.getRoot(), 4);
        System.out.println("\nInorder traversal after"
                + " deletion of 4:");
        avl.inorder(avl.getRoot());
    }

    public static Node deleteNode(Node root, int data) {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return root;

        // If the data to be deleted is smaller 
        // than the root's data, then it lies in 
        // left subtree
        if (data < root.data)
            root.left = deleteNode(root.left, data);

            // If the data to be deleted is greater 
            // than the root's data, then it lies in 
            // right subtree
        else if (data > root.data)
            root.right = deleteNode(root.right, data);

            // if data is same as root's data, then 
            // this is the node to be deleted
        else {
            // node with only one child or no child
            if ((root.left == null) ||
                    (root.right == null)) {
                Node temp = root.left != null ?
                        root.left : root.right;

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else // One child case
                    root = temp; // Copy the contents of 
                // the non-empty child
            } else {
                // node with two children: Get the 
                // inorder successor (smallest in 
                // the right subtree)
                Node temp = (root.right);
                while(temp.left != null){
                    temp = temp.left;
                }

                // Copy the inorder successor's 
                // data to this node
                root.data = temp.data;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.data);
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = Math.max(height(root.left),
                height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS 
        // NODE (to check whether this node 
        // became unbalanced)
        int balance = getBalanceFactor(root);

        // If this node becomes unbalanced, then 
        // there are 4 cases

        // Left Left Case
        if (balance > 1 && getBalanceFactor(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalanceFactor(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalanceFactor(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalanceFactor(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
}
