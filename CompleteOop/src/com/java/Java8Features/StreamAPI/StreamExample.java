package com.java.Java8Features.StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {

        //1. Stream of Collection (List,Set,Collection)
        List<String> list = Arrays.asList("Mango", "Apple", "Banana");
        Stream<String> myStream = list.stream();
//        myStream.forEach(c -> System.out.println(c));

        //2. creating an empty stream
        Stream<String> streamEmpty = Stream.empty();

        //3. Stream of Array
        String[] arr = {"Mango", "Apple", "Banana"};
        List<String> list1 = Arrays.asList(arr);
//        list1.forEach(c -> System.out.println(c));

        //4.
//        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        //5. Stream.iterate()
       Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(10);
       streamIterated.forEach(c -> System.out.println(c));

        //6. Stream.builder()
        Stream<String> streamBuilder =
                Stream.<String>builder().add("a").add("b").add("c").build();

//        streamBuilder.forEach(c -> System.out.println(c));

        //7. Stream.generate()
        Stream<String> streamGenerated =
                Stream.generate(() -> "element").limit(10);

//        streamGenerated.forEach(c -> System.out.println(c));

    }
}
