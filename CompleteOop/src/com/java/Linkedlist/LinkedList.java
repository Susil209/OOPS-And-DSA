package com.java.Linkedlist;

import com.java.Linkedlist.doublyLL.DoublyLL;

import java.util.HashMap;

public class LinkedList {
    // create head,tail

    private Node head;
    private Node tail;

    //keep track of node size
    private int size;

    public void createLL(int []A, int size){
        Node temp;
        head = new Node(A[0]);
        head.next = null;
        tail=head;

        for(int i=1; i<size; i++){
            temp = new Node(A[i]);
            temp.next = null;
            tail.next = temp;
            tail = temp;
        }
    }

    // method to insert node at first
    public void insertAtFirst(int data){
        //1. create a new node
        Node newNode = new Node(data);

        //2. assign its next to head
        newNode.next = head;

        //3. reassign the head
        head=newNode;

        //4.check if it is single node then tail=head
        if(tail==null){
            tail=head;
        }

        //5.change the size
        size = size+1;

    }

    //insert a element at last
    public void insertAtLast(Node p, int data){
        if(tail == null){
            insertAtFirst(data);
            return;
        }
        Node newNode = new Node(data);
        tail.next = newNode;
        tail=newNode;
        size = size+1;
    }

    public int count(Node p){
        int count=0;
        while(p !=null){
            count = count+1;
            p=p.next;
        }
        return count;
    }

    //insert at a given position
    public void insert(Node p,int pos,int data){
        if(pos < 0 || pos > count(p)) return;

        // creating a temporary node
        Node temp = new Node(data);

        if(pos==0){
            insertAtFirst(data);
        }
        else{
            for(int i=0; i<pos-1; i++){
                p=p.next;
            }
            temp.next=p.next;
            p.next=temp;
        }
    }

    //insert node in a sorted linked list
    public void sortedInsert(Node p,int data){
        Node q = p;
        Node temp = new Node(data);
        if(head==null){
            head=temp;
        }
        else{
            while(p.data < data) {
                q = p;
                p = p.next;
            }
            if(p==head){
                temp.next=head;
                head=temp;
            }
            else{
                temp.next=q.next;
                q.next=temp;
            }

        }

    }

    //Delete a node
    //1. Delete at first
    public int deleteAtFirst(Node p){
        int x=head.data;
        head=head.next;
        return x;
    }

    //2. Delete at any given position
    public int delete(Node p,int pos){
        int x;
        Node q=p;
        //if pos is out of range
        if(pos < 0 || pos > count(p)){
            return -1;
        }

        //first node
        if(pos == 1){
            System.out.println(deleteAtFirst(p));
        }
        else{
            for(int i=0;i<pos-1;i++){
                q=p;
                p=p.next;
            }
            q.next=p.next;
            x=p.data;
            return x;
        }
        return -1;
    }

    // Check if linked list is sorted (ascending)
    public boolean isSorted(Node p){
        int min = Integer.MIN_VALUE;
        while(p!=null){
            if(min > p.data){
                return false;
            }
            min = p.data;
            p=p.next;
        }
        return true;
    }


    //Remove duplicates from sorted linked list

    /*
    Time Complexity: O(N)
    Space Complexity: O(1)

    Where N is the number of nodes in the Linked list.
     */

    public void RemoveDuplicatesSorted(Node head){
        Node p = head;
        if(head == null) return;

        while(p.next != null) {
            if (p.data != p.next.data) {
                p = p.next;
            } else {
                p.next = p.next.next;
            }
        }
    }



    //Remove duplicates from unsorted linked list

    /*
    Time Complexity: O(N^2)
    Space Complexity: O(1)

    Where N is the number of nodes in the Linked list.
    */


    public void removeDuplicates(Node head) {

        Node p,q;
        p = head;

        // Outer loop to pick element.
        while (p != null){
            // Initialize the inner loop pointer.
            q = p.next;

            // Keep track of previous node.
            Node prev = p;
            while (q != null){
                if (p.data == q.data){
                    // Found a duplicate of node 'p'. Now, we need to remove it.
                    // Firstly update the next pointer of the previous node.
                    prev.next = q.next;
                    // Move the inner loop pointer to the next node.
                    q = prev.next;
                }
                else{
                    // Node 'q' is not a duplicate. So, move to the next node.
                    prev = q;
                    q = q.next;
                }
            }
            // Move the outer loop pointer to the next node.
            p = p.next;
        }
    }

    //Remove duplicates from unsorted linked list
    //Using hashing

    /*
    Time Complexity: O(N)
    Space Complexity: O(N)

    Where N is the number of nodes in the Linked list.
    */



    // Reverse a list
    public Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;

        }

        return prev;
    }


    public void RemoveDuplicateHashMap(Node head){
        Node p = head;
        // Keep track of previous node.
        Node prev = null;

        HashMap<Integer, Boolean> seen = new HashMap<>();

        // Iterate over the given linked list.
        while (p!=null){
            int data = p.data;

            if(seen.containsKey(data)){
                // Node has been encountered before, so it's a duplicate.
                // Firstly update the next pointer of the previous node.
                prev.next = p.next;
                p=prev.next;
            }else{
                seen.put(data,true);

                prev=p;
                p=p.next;
            }
        }
    }


    // Concatenating 2 lists
    public void concatList(Node first,Node second){

        Node temp = first;
        while(temp.next!=null){
            temp = temp.next;
        }

        if(second!=null){
            temp.next = second;
        }

    }


    //Merge two sorted lists
    public Node mergeList(Node head1,Node head2){

        Node first = head1;
        Node second = head2;

        Node third;
        Node last;

        if(first.data < second.data) {
            third = last = first;
            first = first.next;
            last.next = null;
        }else {
            third = last = second;
            second = second.next;
            last.next = null;
        }

        while (first!=null && second!=null){
            if(first.data < second.data){
                last.next=first;
                last=first;
                first=first.next;
                last.next=null;
            }else {
                last.next=second;
                last=second;
                second=second.next;
                last.next=null;
            }
        }

        if(first == null)
            last.next=second;
        else
            last.next=first;

        return third;
    }


    // Find middle in a list

    public Node findMiddle(Node head){
        // Approach-1
        /*
        int length = countNode();
        Node p = head;
        for(int i=0 ; i<(length/2); i++){
            p = p.next;
        }

        return (p.data);


         */


        //Approach-2 (Using 2 pointers)


        Node p = head,q = head.next;

        while(q!=null && q.next!=null){
            q=q.next.next;
            p=p.next;
        }


        return p;



        // Approach -3 (Using stack)

        /*
        Stack<Node> s = new Stack<>();
        Node p = head;

        while (p!=null) {
            s.push(p);
            p=p.next;
        }

        for (int i = 0; i < s.size() / 2; i++) {
            s.pop();
        }

        return s.peek().data;

         */
    }


    // Check for Palindrome

    public boolean isPalindrome(Node head) {
        if(head.next == null) {
            return true;
        }

        //step 1 . find Middle
        Node middle = findMiddle(head);


        //step2 . reverse List after Middle
        Node temp = middle.next;
        middle.next = reverseList(temp);

        //step3 - Compare both halves
        Node head1 = head;
        Node head2 = middle.next;

        while(head2 != null) {
            if(head2.data != head1.data) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        //step4 - repeat step 2
        temp = middle.next;
        middle.next = reverseList(temp);

        return true;

    }



    //Display the linked list
    public void displayList(Node head){
        // create a temp variable to traverse the list
        Node temp=head;

        while(temp!=null){
            System.out.print(temp.data + "->");
            temp=temp.next;
        }

        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int []A = {10,20,30,40,50};

        list.createLL(A,A.length);

        System.out.println("List is");
        list.displayList(list.head);

        System.out.println("Middle element is " + list.findMiddle(list.head).data);

        System.out.println("Reverse list is");
        Node revListHead = list.reverseList(list.head);
        list.displayList(revListHead);

        System.out.println(list.isPalindrome(list.head));

//        if(list.isPalindrome())
//            System.out.println("List is palindrome");
//        else
//            System.out.println("Not palindrome.");

//        list.displayList(list.head);


//        list.insertAtFirst(10);
//        list.insertAtFirst(20);
//        list.insertAtFirst(30);
//        list.insertAtFirst(40);
//        list.insertAtFirst(50);
//
//        list.displayList(); // 50.40.30.20.10
//        list.insert(list.head, 2, 90);
//        list.displayList(); // 50.40.90.30.20.10

//        list.insertAtLast(list.tail, 3);
//        list.insertAtLast(list.tail, 6);
//        list.insertAtLast(list.tail, 9);
//
//        System.out.println("Displaying list 1 ");
//        list.displayList(list.head); // 10.20.30.40.50

//        list.sortedInsert(list.head, 9);
//        list.displayList();

//        int deletedElement = list.delete(list.head, 4);
//        System.out.println(deletedElement);
//        list.displayList(); // 10.20.30.50

//        if(list.isSorted(list.head)){
//            System.out.println("List is sorted.");
//        }else{
//            System.out.println("Not sorted.");
//        }

//        list.removeDuplicates(list.head);
//        list.displayList();

//        list.RemoveDuplicatesSorted(list.head);
//        list.displayList();

//        list.RemoveDuplicateHashMap(list.head);
//        list.displayList();

//        LinkedList list2 = new LinkedList();

//        list2.insertAtLast(list.tail, 2);
//        list2.insertAtLast(list.tail, 3);
//        list2.insertAtLast(list.tail, 5);
//        System.out.println("Displaying list 2 ");
//        list2.displayList(list2.head);

//        System.out.println("After concat ");
//        list.concatList(list.head,list2.head);
//        list.displayList();

//        System.out.println("After merge ");
//        Node ans = list.mergeList(list.head,list2.head);
//        list.displayList(ans);
    }



    //create Node class
    public class Node{
        //Node has data and next ref variable
        private int data;
        private Node next;

        //create a constructor
        public Node(int data){
            this.data=data;
        }
    }
}
