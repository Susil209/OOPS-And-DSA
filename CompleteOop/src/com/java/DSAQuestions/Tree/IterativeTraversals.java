package com.java.DSAQuestions.Tree;

import java.util.*;

public class IterativeTraversals {
    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> preOrder = preOrderIterative(root);
        System.out.println("Preorder traversal: "+preOrder);

        List<Integer> postOrder = postOrderIterative(root);
        System.out.println("Postorder traversal: "+ postOrder);

        List<Integer> inOrder = inOrderIterative(root);
        System.out.println("Inorder traversal: "+ inOrder);
    }

    private static List<Integer> inOrderIterative(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Stack<Node> st = new Stack<>();
        Stack<Boolean> visited = new Stack<>();

        st.push(root);
        visited.push(false);

        while(!st.isEmpty()){
            Node temp = st.peek();
            st.pop();

            boolean isVisited = visited.peek();
            visited.pop();

            if(!isVisited){
                // 1st time visit
                // push right,root,left
                if(temp.right != null){
                    st.push(temp.right);
                    visited.push(false);
                }

                // 2nd time visit
                st.push(temp);
                visited.push(true);

                // 1st time visit
                if(temp.left != null){
                    st.push(temp.left);
                    visited.push(false);
                }
            }else{
                ans.add(temp.data);
            }
        }

        return ans;
    }

    private static List<Integer> postOrderIterative(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Stack<Node> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()){
            Node temp = st.peek();
            st.pop();

            ans.add(temp.data);

            if(temp.left != null) st.push(temp.left);
            if(temp.right != null) st.push(temp.right);
        }

        Collections.reverse(ans);
        return ans;
    }

    private static List<Integer> preOrderIterative(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Stack<Node> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()){
            Node temp = st.peek();
            st.pop();

            ans.add(temp.data);

            if(temp.right != null) st.push(temp.right);
            if(temp.left != null) st.push(temp.left);
        }

        return ans;
    }
}
