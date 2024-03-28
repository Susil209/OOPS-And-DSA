package com.java.Overriding;
import java.io.*;

public class Demo {
    public class P{
        public  void m1() throws IOException{

        }
    }

    public class C extends P{
        public void m1() throws ArithmeticException,NullPointerException,ClassCastException{

        }
    }
}
