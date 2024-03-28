package com.java.DSAQuestions.Matrix;

class Matrix{
    private int[] A;
    private int size;

    public void setMatrix(int r, int c, int ele){
        if(r == c){
            A[r-1] = ele;
        }
    }

    Matrix(int size){
        this.A = new int[size];
        this.size = size;
    }

    public int getMatrix(int r,int c){
        if(r == c){
            return A[r-1];
        }
        return 0;
    }


    public void displayMatrix(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i==j){
                    System.out.print(A[i]+" ");
                }else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

}


public class DiagonalMatrix {
    public static void main(String[] args) {
        Matrix m = new Matrix(4);

        m.setMatrix(1,1,10);
        m.setMatrix(2,2,20);
        m.setMatrix(3,3,30);
        m.setMatrix(4,4,40);

        m.displayMatrix();

        System.out.println("Get element :" + m.getMatrix(2,2));

    }
}
