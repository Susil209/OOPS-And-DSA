package com.java.Collection;

import java.util.*;

// Internal implementation of Cursors

public class CursorDemo {
    public static void main(String[] args) {

        Vector<Object> v = new Vector<>();
        ArrayList<Object> a = new ArrayList<>();

        Enumeration<Object> e = v.elements();
        Iterator<Object> itr = v.iterator();
        ListIterator<Object> litr = v.listIterator();


        Iterator<Object> it = a.iterator();
        ListIterator<Object> lit  = a.listIterator();

        System.out.println(e.getClass().getName());    //java.util.Vector$1
        System.out.println(itr.getClass().getName());  //java.util.Vector$Itr
        System.out.println(litr.getClass().getName()); //java.util.Vector$ListItr

        System.out.println(it.getClass().getName());  //java.util.ArrayList$Itr
        System.out.println(lit.getClass().getName()); //java.util.ArrayList$ListItr
    }
}
