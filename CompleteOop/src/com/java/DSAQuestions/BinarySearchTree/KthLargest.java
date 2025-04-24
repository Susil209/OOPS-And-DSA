package com.java.DSAQuestions.BinarySearchTree;

import com.java.DSAQuestions.Tree.Node;

import java.util.PriorityQueue;

public class KthLargest {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        int k = 2;
        System.out.println(k +"th largest element is :");
        System.out.println(KthLargestElement(root,k));
    }

    private static int KthLargestElement(Node root, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        findKhLargest(root, pq, k);

        if(pq.peek() != null)
            return pq.peek();
        return 0;
    }

    private static void findKhLargest(Node root, PriorityQueue<Integer> pq, int k) {
        if(root==null) return;

        if(pq.size() < k) {
            pq.add(root.data);
        } else {

                if(pq.peek() != null && pq.peek() < root.data) {
                    pq.remove();
                    pq.add(root.data);
                }

        }

        findKhLargest(root.left, pq, k);
        findKhLargest(root.right, pq, k);
    }
}
