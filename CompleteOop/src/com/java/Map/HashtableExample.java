package com.java.Map;

import java.util.Hashtable;

public class HashtableExample {
    public static void main(String[] args) {
        // default initialCapacity = 11 and form factor = 0.75
        // Hashtable<Object,Object> h = new Hashtable<>();

        Hashtable<Object,Object> h = new Hashtable<>(25);

        h.put(new NewObj(5),"A");
        h.put(new NewObj(2),"B");
        h.put(new NewObj(6),"C");
        h.put(new NewObj(15),"D");
        h.put(new NewObj(23),"E");
        h.put(new NewObj(16),"F");
       //h.put("Susil",null); // RE : NullPointerException

        // for customized capacity of 25
        System.out.println(h); // {23=E, 16=F, 15=D, 6=C, 5=A, 2=B}

        // for default initial capacity of 11
        // System.out.println(h); // {6=C, 16=F, 5=A, 15=D, 2=B, 23=E}
    }
}

class NewObj{
    int i;
    NewObj(int i) {
        this.i=i;
    }

    public int hashCode(){
        return i;
        // return i % 9; // {16=F, 15=D, 6=C, 23=E, 5=A, 2=B}
    }

    public String toString(){
        return i+"";
    }
}
