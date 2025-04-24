package com.java.DSAQuestions.BinarySearchTree;

import com.java.DSAQuestions.Tree.Node;

import java.util.Arrays;
import java.util.List;

import static com.java.DSAQuestions.Tree.CreateBTree.inOrder;

    public class BSTFromPostorder {

        public static void main(String[] args) {
            List<Integer> post = Arrays.asList(1, 5 , 7,50, 40, 10);
            int index = post.size()-1;

            Node root = bstFromPostorder(post);
            System.out.println("Inorder elements are: ");
            inOrder(root);
        }

//        Since Java is pass-by-value, primitive types like int cannot be passed by reference directly.
//        To simulate this, we can use a mutable wrapper class, like an array or a custom wrapper object.
//        We’ll use a simple wrapper class IndexWrapper to simulate pass-by-reference for the index.

        // Wrapper class to pass index by reference
        static class IndexWrapper {
            int index;
            IndexWrapper(int index) {
                this.index = index;
            }
        }

        private static Node bstFromPostorder(List<Integer> post) {
            // Approach-1 (Brute force)
            // TC = O(n^2), SC = O(n)

            // create BST
//            return createBSTFromPostorder(post, 0 , post.size()-1);

            // Approach-2 (Optimum using range)
            // TC = O(n), SC = O(n)
            IndexWrapper idw = new IndexWrapper(post.size() - 1);
            return createBSTFromPostorder(post, idw, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private static Node createBSTFromPostorder(List<Integer> post, IndexWrapper index, int lower, int upper) {
            if (index.index < 0) return null;

            int val = post.get(index.index);
            if (val < lower || val > upper) return null;

            // Create root and decrease index
            Node root = new Node(val);
            index.index--;

            // Create right subtree first, then left (reverse postorder)
            root.right = createBSTFromPostorder(post, index, val, upper);
            root.left = createBSTFromPostorder(post, index, lower, val);

            return root;
        }

        private static Node createBSTFromPostorder(List<Integer> post, int start, int end) {
            // Base case
            if(start > end) return null;

            // create root
            Node root = new Node(post.get(end));

            int i;
            for(i = end-1; i>= start; i--){
                if(post.get(i) < root.data)
                    break;
            }

            root.left = createBSTFromPostorder(post, start, i);
//            root.right = createBSTFromPostorder(post, i+1, post.size()-2); // wrong
            root.right = createBSTFromPostorder(post, i+1 , end-1);

            return root;

//            Why is this wrong?
//            The end parameter in the current function call is the root's index in the post list.
//            So for the right subtree, the correct range is from i+1 to end - 1
//            (i.e., the elements after the left subtree and before the root).
//            Using post.size() - 2 is assuming that the size never changes,
//            which leads to wrong or excessive recursion — potentially causing a StackOverflow.
        }
    }
