package com.java.DSAQuestions.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCousins {
    static int par1=0, par2=0, l1=0, l2=0;
    private static boolean isCousin(Node root, int a, int b) {
        // 1. The two Nodes should be on the same level in the
        // binary tree.
        // 2. The two Nodes should not be siblings (means that
        // they should
        // not have the same parent Node).

        // Approach-1(using queue)

        //corner case
        /*if(levelOf(root,a,1) == levelOf(root,b,1)){
            if(levelOf(root,a,1) == -1 && levelOf(root,b,1) == -1)
                return false;
        }

        int level=1;
        return levelOf(root, a, level) == levelOf(root, b, level) && !sameParent(root, a, b);*/

        //Approach-2(without using queue)
        help(root, a, b, 0, root.data);
        return l1 == l2 && par1 != par2;

    }

    public static void help(Node root, int a, int b, int level, int prev){
        if(root==null){
            return;
        }
        if(root.data==a){
            l1=level;
            par1=prev;
        }
        if(root.data==b){
            l2=level;
            par2=prev;
        }
        help(root.left, a, b, level+1, root.data);
        help(root.right, a, b, level+1, root.data);
    }

    private static int levelOf(Node root, int a, int level) {
        if(root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int nodeLevel=-1;

        while(!q.isEmpty()){
            int size = q.size();
            while(size!=0){
                Node temp = q.poll();

                if(temp!=null){
                    if(temp.data == a) nodeLevel=level;

                    if(temp.left != null) q.offer(temp.left);
                    if(temp.right != null) q.offer(temp.right);
                }
                size--;
            }

            level++;
            if(nodeLevel!=-1) break;
        }

        return nodeLevel;
    }

    private static boolean sameParent(Node root, int a, int b) {
        if(root == null) return false;

        if(root.left!=null && root.right!=null){
            if( (root.left.data == a && root.right.data == b)
                    || (root.left.data == b && root.right.data == a))
                return true;
        }

        return sameParent(root.left,a,b) || sameParent(root.right,a,b);
    }


    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        if(isCousin(root,4,5)){
            System.out.println("They are cousins.");
        }else{
            System.out.println("Not cousins");
        }
    }


}
