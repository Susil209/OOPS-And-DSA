package com.java.Map;

import java.util.WeakHashMap;

public class WeakHashMapExample {
    public static void main(String[] args) throws Exception{
        WeakHashMap<Object,String> mp = new WeakHashMap<>();
        Temp t = new Temp();
        mp.put(t,"John");
        System.out.println(mp); //  {temp=John}

        // make the object null means 't' no more reference to Temp object
        t=null;
        System.gc(); // call the garbage collector that call 'finalize()'
                     // to destroy the Temp object
        Thread.sleep(5000); // main thread sleeps so gc can do its job

        // finally in the hashmap
        System.out.println(mp); // {}


    }
}

class Temp{
    public String toString(){
        return "temp";
    }

    protected void finalize(){
        System.out.println("Finalize method is called");
    }
}
