package com.java.Linkedlist;

public class displayRecursively {

    private Node head;
    private Node tail;

    //keep track of node size
    private int size;

    public class Node{
        //Node has data and next ref variable
        private int data;
        private Node next;

        //create a constructor
        public Node(int data){
            this.data=data;
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

    public void Rdisplay(Node p){
        //base case
        if(p !=null){
            System.out.print(p.data + "->");
            Rdisplay(p.next);
        }
        if(p ==null){
            System.out.println("End");
        }

    }


    //printing in reverse order
//    public void Rdisplay(Node p){
//
//        //base case
//        if(p!=null) {
//            Rdisplay(p.next);
//            System.out.print(p.data + "->");
//        }
//    }

    public int countNode(Node p){
        int count=0;
        while(p !=null){
            count = count+1;
            p=p.next;
        }
        return count;
    }

    //find sum of all nodes
    public int sumOfNodes(Node p){
        int sum=0;
        while(p!=null){
            sum=sum+ p.data;
            p=p.next;
        }

        return sum;
    }

    //find max element
    public int maxElement(Node p){
        int max = Integer.MIN_VALUE;
        while(p!=null){
            if(p.data > max){
                max=p.data;
            }
            p=p.next;
        }

        return max;
    }


    public static void main(String[] args) {
        displayRecursively list = new displayRecursively();

        list.insertAtFirst(40);
        list.insertAtFirst(20);
        list.insertAtFirst(80);
        list.insertAtFirst(60);

//        list.Rdisplay(list.head);
//        System.out.println(list.size);
//        System.out.println
//        ("Number of nodes "+ list.countNode(list.head));

//        System.out.println("Sum is " + list.sumOfNodes(list.head));

        System.out.println("Max value = "+ list.maxElement(list.head));
    }
}
