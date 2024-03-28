package com.java.DSAQuestions.Stack;

public class DynamicStack extends Stack{
    public DynamicStack() {
        super(); // it will call Stack()
    }

    public DynamicStack(int size) {
        super(size);// it will call Stack(size)
    }

    @Override
    public void push(int x) {
        // if array is full
        if(this.isFull()){
            // double the size and create a new array
            // copy all the elements of the existing array to the new one
            int[] temp = new int[st.length*2];

            for (int i = 0; i < st.length; i++) {
                temp[i] = st[i];
            }

            st = temp;
        }
        // else just call the push method of Stack class
        super.push(x);
    }
}
