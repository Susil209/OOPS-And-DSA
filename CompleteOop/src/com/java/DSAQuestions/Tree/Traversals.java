package com.java.DSAQuestions.Tree;

import java.util.*;

public class Traversals {

    public static void Preorder(Node root){
        // Approach-1(Recursive)
        // TC = O(n), SC=O(h)
        /*if (root == null) return;

        System.out.print(root.data+ " ");
        Preorder(root.left);
        Preorder(root.right);*/

        // Approach-2(Iterative)

        Stack<Node> st = new Stack<>();

        while(root!=null || !st.isEmpty()){
            if(root != null){
                System.out.print(root.data + " ");
                st.push(root);
                root = root.left;
            }else {
                root = st.peek();
                st.pop();
                root = root.right;
            }
        }
    }

    public static void Inorder(Node root){
        // Approach-1(Recursive)
        // TC = O(n), SC=O(h)
/*        if (root == null) return;

        Inorder(root.left);
        System.out.print(root.data+ " ");
        Inorder(root.right);*/

        //Approach-2(Iterative)

        Stack<Node> st = new Stack<>();

        while(root!=null || !st.isEmpty()){
            if(root != null){
                st.push(root);
                root = root.left;
            }else {
                root = st.peek();
                System.out.print(root.data + " ");
                st.pop();
                root = root.right;
            }
        }
    }

    public static void PostOrder(Node root){
        /*if (root == null) return;

        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.data+ " ");*/

        // Approach-2 (Iterative)

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        if (root == null) return;
        st1.push(root);

        while (!st1.isEmpty()){
            Node temp = st1.pop();
            st2.push(temp);

            if(temp.left!=null)
                st1.push(temp.left);
            if(temp.right!=null)
                st1.push(temp.right);

        }


        while (!st2.isEmpty()){
            Node t = st2.peek();
            System.out.print(t.data + " ");
            st2.pop();
        }

    }

    public static List<List<Integer>> levelOrderTraversal(Node root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null)
            return res;


        Queue<Node> q = new LinkedList<>();
        q.add(root);


        while(!q.isEmpty()) {

            int levelSize = q.size();
            List<Integer> currLevel = new ArrayList<>();

            for(int i = 0; i < levelSize; i++) {

                Node currNode = q.poll();

                if(currNode != null){
                    currLevel.add(currNode.data);


                    if (currNode.left != null)
                        q.add(currNode.left);
                    if (currNode.right != null)
                        q.add(currNode.right);
                }


            }

            res.add(currLevel);
        }
        return res;
    }
    public static List<Integer> levelOrder(Node root, List<Integer> ans)
    {

        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){

            Node temp = q.peek();
            q.poll();
            ans.add(temp.data);


            if(temp.left!=null){
                q.offer(temp.left);
            }

            if(temp.right!=null){
                q.offer(temp.right);
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        /*
                    1
             2             3
                4       5
              6       7

             in:  2 4 6 1 7 5 3
         */


        /*Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.right = new Node(4);
        root.right.left = new Node(5);

        root.left.right.left = new Node(6);
        root.right.left.left = new Node(7);

        Inorder(root);*/

        /*
                    1
             2             3
           4                  5
               6          7

          post:  6 4 2 7 5 3 1

        */
        /*Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.right.right = new Node(5);

        root.left.left.right = new Node(6);
        root.right.right.left = new Node(7);

        PostOrder(root);*/


        /*
                    1
                         2
                      3     4
                          5    6
                              7

            pre: 1 2 3 4 5 6 7
           post: 3 5 7 6 4 2 1
           in  : 1 3 2 5 4 7 6

        */

        /*Node root = new Node(1);

        root.right = new Node(2);
        root.right.left = new Node(3);

        root.right.right = new Node(4);
        root.right.right.left = new Node(5);

        root.right.right.right = new Node(6);
        root.right.right.right.left = new Node(7);*/

//        PostOrder(root);
//        Preorder(root);
//        Inorder(root);


        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<List<Integer>> res = levelOrderTraversal(root);
        System.out.println(res);
    }
}
