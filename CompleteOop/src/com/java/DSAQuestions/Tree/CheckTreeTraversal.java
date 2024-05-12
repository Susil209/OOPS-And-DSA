package com.java.DSAQuestions.Tree;

//https://www.geeksforgeeks.org/problems/check-tree-traversal--141628/1

public class CheckTreeTraversal {
    private static boolean isValid = true;

    private static int find(int[] arr,int start,int end,int x)
    {
        for(int i=start;i<=end;i++)
        {
            if(arr[i]==x)
                return i;
        }

        return -1;
    }

    // from pre and inorder traversal
    private static Node createTree1(int[] in,int[] pre,
                      int inStart,int inEnd, int index)
    {

        if(inStart>inEnd)
            return null;

        Node root = new Node(pre[index]);

        int pos = find(in,inStart,inEnd,pre[index]);

        // if ele pos is not found return false(not valid)
        if(pos==-1)
        {
            isValid = false;
            return null;
        }

        root.left=createTree1(in,pre,inStart,pos-1,index+1);


        root.right=createTree1(in,pre,pos+1,inEnd,index+(pos-inStart)+1);

        return root;
    }


    // from post and inorder traversal
    private static Node createTree2(int[] in,int[] post,
                      int inStart,int inEnd, int index)
    {

        if(inStart>inEnd)
            return null;

        Node root = new Node(post[index]);

        int pos = find(in,inStart,inEnd,post[index]);

        if(pos==-1)
        {
            isValid = false;
            return null;
        }

        root.right=createTree2(in,post,pos+1,inEnd,index-1);

        root.left=createTree2(in,post,inStart,pos-1,index-(inEnd-pos+1));

        return root;
    }

    private static boolean check(Node root1,Node root2){
        // if both roots are NULL,return true(same empty tree)
        if(root1==null && root2==null)
            return true;

        // if any one of root is NULL,return false
        if(root1==null || root2==null)
            return false;

        // if root data of both tree not matched return false
        if(root1.data != root2.data)
            return false;

        return check(root1.left,root2.left) && check(root1.right,root2.right);
    }

    private static boolean checkTree(int[] preorder, int[] inorder, int[] postorder, int N)
    {

        Node tree1 = createTree1(inorder,preorder,0,N-1,0);
        Node tree2 = createTree2(inorder,postorder,0,N-1,N-1);

        // if not valid return false
        if(!isValid)
            return false;

        // if either of tree is NULL,return false
        if(tree1==null || tree2==null)
            return false;

        return check(tree1,tree2);
    }

    public static void main(String[] args) {
        int N = 5;
        int[] preorder = {1, 2, 4, 5, 3};
        int[] inorder = {4, 2, 5, 1, 3};
        int[] postorder = {4, 5, 2, 3, 1};

        if(checkTree(preorder,inorder,postorder,N))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
