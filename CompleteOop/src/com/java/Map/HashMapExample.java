package com.java.Map;

import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        // create an empty hashmap object
        HashMap<String,Integer> m = new HashMap<>();

        m.put("busily",100);
        m.put("suresh",200);
        m.put("karim",290);
        m.put("vikas",1000);

        // Insertion order is not preserved, printed based on hashcode of keys
        System.out.println(m); // { K=V , K=V ... }
        // {karim=290, busily=100, suresh=200, vikas=1000}

        // value of key "karim" is replaced, but it returns the old object value
        System.out.println(m.put("karim",500)); // 290

        //Collection views of Map

        Set<String> s = m.keySet();
        // returns set of keys in a Collection view
        System.out.println(s); // [karim, busily, suresh, vikas]


        Collection<Integer> c = m.values();
        // returns Collection of values
        System.out.println(c); // [500, 100, 200, 1000]

        Set<Map.Entry<String, Integer>> s1 = m.entrySet();
        //return a collection view of key-value pair
        System.out.println(s1); // [ K=V, K=V ... ]
        //[karim=500, busily=100, suresh=200, vikas=1000]


        // Inorder to get each object one by one use cursor
        Iterator<Map.Entry<String, Integer>> itr = s1.iterator();

        while (itr.hasNext()){
            Map.Entry<String, Integer> m1 = itr.next();
            // get key and value from Entry interface
            System.out.println(m1.getKey()+"..."+m1.getValue());
            /*
                karim...500
                busily...100
                suresh...200
                vikas...1000
             */

            if(m1.getKey().equals("vikas")) {
                m1.setValue(10000);
            }
        }
        System.out.println(m); //{karim=500, busily=100, suresh=200, vikas=10000}
    }
}
