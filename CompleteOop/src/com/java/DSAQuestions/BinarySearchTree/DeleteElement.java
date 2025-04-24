package com.java.DSAQuestions.BinarySearchTree;

import com.java.DSAQuestions.Tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteElement {

    private static Node deleteNode(Node root,int key){
        // Approach-1 (Recursive)
        // TC = O(log n) Best,O(n) worst
        // SC = O(log n) Best, O(n) worst

//        // if no root present, return null
//        if (root == null)
//            return null;
//
//        // search the key node to be deleted, can be present either in left or right
//        if (key < root.data)
//            // search in left
//            root.left = deleteNode(root.left, key);
//        else if (key > root.data)
//            root.right = deleteNode(root.right, key);
//            // you got the key
//        else
//        {
//            // There can be 3 cases
//            // case-1 (leaf node)
//            if (root.left == null && root.right == null){
//                return null;
//            }
//
//            // case-2 (single child present)
//            else if(root.right == null) // left child present
//            {
//                // store the left child in temp
//                return root.left;
//            }
//            else if(root.left == null) // right present
//            {
//                return root.right;
//            }
//
//            // case-3: Both child present
//            // Now here before deleting we need to find inorder predecessor or
//            // successor to be replaced with root
//            // In order to determine that we have to check height of the tree
//            // from root's left and right
//            // Either of the side's height is greater delete from that end
//            else
//            {
//                // delete from left(predecessor)
//                if(Height(root.left) > Height(root.right)){
//                    Node pre = InPre(root.left); // find the node
//                    root.data = pre.data; // copy the dataue
//                    root.left = deleteNode(root.left, pre.data);
//                }
//
//                else{
//                    Node succ = InSucc(root.right); // find the node
//                    root.data = succ.data; // copy the dataue
//                    root.right = deleteNode(root.right, succ.data);
//                }
//            }
//
//
//
//        }

 //       return root;


        // Approach-2 (iterative)
        //Case	Time Complexity	Space Complexity
        //Balanced BST	O(log N)	O(1)
        //Skewed BST	O(N)	O(1)

        Node parent = null;
        Node node = root;

        // Step 1: Find the node to delete
        while (node!=null && node.data != key) {
            parent = node;
            if (key < node.data)
                node = node.left;
            else
                node = node.right;
        }

        // If node not found, return original root
        if (node == null) return root;

        // Step 2: Handle the three deletion cases

        // Case 1: Node has at most one child
        Node replacement;
        if (node.left == null) {
            replacement = node.right;  // Could be null or right subtree
        } else if (node.right == null) {
            replacement = node.left;  // Could be null or left subtree
        } else {
            // Case 2: Node has two children → Find the inorder successor (leftmost in right subtree)
            Node succParent = node;
            Node succ = node.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }

            // Replace node's dataue with successor's dataue
            node.data = succ.data;

            // Now delete the successor node (which is guaranteed to have at most one child)
            if (succParent.left == succ)
                succParent.left = succ.right;
            else
                succParent.right = succ.right;

            return root;
        }

        // Case 3: Node has one or zero children
        if (parent != null) {
            // If deleting the root node, return the new root
            
            return replacement;
        }

        // Update the parent's child reference
        if (parent.left == node)
            parent.left = replacement;
        else
            parent.right = replacement;

        
        return root;

    }

    private static Node InPre(Node root) {
        while (root!=null && root.right!=null)
            root = root.right;

        return root;
    }

    private static Node InSucc(Node root) {
        while (root!=null && root.left!=null)
            root = root.left;

        return root;
    }

    private static int Height(Node root) {
        int x,y;
        if(root == null) return 0;

        x = Height(root.left);
        y = Height(root.right);

        return Math.max(x, y);
    }

    private static Node insertInBST(Node root, int data) {

        //Approach-2(Using Iteration)
        // TC = O(n), SC = O(1)
        if(root == null){
            return new Node(data);
        }

        Node prev = null;
        Node curr = root;

        while(curr != null){
            prev = curr;

            if(data == curr.data)
                return curr;
            else if(data < curr.data)
                curr = curr.left;
            else
                curr = curr.right;
        }

        curr = new Node(data);

        if(curr.data < prev.data)
            prev.left = curr;
        else
            prev.right = curr;

        return root;
    }

    private static void printLevelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){

            Node temp = q.peek();
            q.poll();
            System.out.printf(temp.data + " ");

            if(temp.left!=null){
                q.offer(temp.left);
            }

            if(temp.right!=null){
                q.offer(temp.right);
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[] nodes = {4,2,7,1,3};
        Node root = null;

        for (int node : nodes) {
            root = insertInBST(root, node);
        }

        System.out.println("The level order traversal of BST: ");
        printLevelOrder(root);

        // inserting another node
        System.out.println("After inserting another node: ");
        insertInBST(root, 15);
        insertInBST(root, 5);
        printLevelOrder(root);

        System.out.println("After deleting node: ");
        deleteNode(root, 2);
        printLevelOrder(root);
    }
}
