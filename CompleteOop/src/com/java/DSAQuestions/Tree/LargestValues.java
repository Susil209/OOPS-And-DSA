package com.java.DSAQuestions.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValues {
    public static List<Integer> largestValuesInEachLevel(Node root){
        List<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        if(root == null) return ans;
        q.offer(root);


        while(!q.isEmpty()){
            int size = q.size();
            int maxVal = Integer.MIN_VALUE;

            for(int i=0; i<size; i++){
                Node temp = q.poll();

                if(temp!=null){
                    maxVal = Math.max(maxVal, temp.data);

                    if(temp.left != null) q.offer(temp.left);
                    if(temp.right != null) q.offer(temp.right);
                }
            }
            ans.add(maxVal);
        }

        return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> res = largestValuesInEachLevel(root);
        System.out.println(res);
    }
}
