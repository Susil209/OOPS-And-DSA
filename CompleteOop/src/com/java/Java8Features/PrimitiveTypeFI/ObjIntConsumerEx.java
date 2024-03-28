package com.java.Java8Features.PrimitiveTypeFI;

import java.util.function.ObjIntConsumer;

public class ObjIntConsumerEx {
    public static void main(String[] args) {
        ObjIntConsumer<String> c = (s,i) -> System.out.println(s.length()+i);
        c.accept("object",5); // 6+5 = 11

        /*
            ObjLongConsumer<T>
            ObjDoubleConsumer<T>
         */
    }
}
