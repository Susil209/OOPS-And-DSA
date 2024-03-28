package com.java.Demo;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo {

    public static int countVowels(String substring) {

        // Check if all characters in the substring appear only once
        StringBuilder collectVowels = new StringBuilder();
        for (char c : substring.toCharArray()) {
            if (c == 'a' || c == 'e' ||c == 'i' || c == 'o' || c == 'u') {
                collectVowels.append(c);
            }
        }

        if (!collectVowels.isEmpty()) {
            return collectVowels.length();
        }else {
            return 0;
        }
    }
    //              012345678
    //  String s = "abciiidef";

    //           01234567891011
//    String s ="wealllovey o u";

    public static int countMaxVowels(String s) {


        int n = s.length();
        int maxCount = 0;

        // Slide the window of size 3
        for (int i = 0; i <= n - 7; i++) { // n=9, i<=6
            String substring = s.substring(i, i + 3);
            maxCount = Math.max(countVowels(substring), maxCount);
        }

        return maxCount;
    }



    public static void main(String[] args) {

//        String s = "abciiidef";
        String s ="weallloveyou";
        int maxVowels = countMaxVowels(s);
        System.out.println("Maximum vowels in a substring of size 3 is = "+ maxVowels);


//        List<Integer> list = Arrays.asList(-9, -18, 0, 25, 4);
//
////        Integer maxValue = list.stream()
////                .max(Comparator.reverseOrder()).get();
//
//        Integer maxValue = list.stream()
//                .max(Integer::compare).get();
//
//        System.out.println(maxValue);

//        // Creating list of integers
//        List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8);
//
//        // Finding sum of all elements
//        Integer sum = array.stream().reduce(0, (a, b) -> a+b);
//
//        // Displaying sum of all elements
//        System.out.println("The sum of all elements is " + sum);


//        List<String> collect = Stream.of("one", "two", "three", "four")
//                .filter(e -> e.length() > 3)
//                .peek(e -> System.out.println("Filtered value: " + e))
//                .map(String::toUpperCase)
//                .peek(e -> System.out.println("Mapped value: " + e))
//                .collect(Collectors.toList());
//
//        System.out.println(collect);


//        int[] arr ={1,2,3,4,5};
//        System.out.println(Arrays.stream(arr).map(x -> x*x).collect(Collectors.toList()));

        // Solution-1
//        int[] intArr = {1,2,3,4,5};
//        Map<Integer,Integer> map = new LinkedHashMap<>();
//        for(Integer i: intArr) {
//            map.put(i, i*i);
//        }
//
//        System.out.println(map);
//
//        map.entrySet()
//                .stream()
//                .map(e -> e.getKey() + " - " + e.getValue())
//                .forEach(System.out::println);

        // Solution-2
        /*
        Map<Integer, Integer> collect = IntStream
                .range(0, arr.length)
                .boxed()
                .collect(Collectors.toMap(index -> arr[index], index -> arr[index] * arr[index]));


        System.out.println(collect);


        //Solution-3
         */

//        Map<Integer, Integer> map = Arrays.stream(arr)
//                .boxed()
//                .collect(Collectors.toMap(i -> i, i -> i * i));
//
//        System.out.println(map);

//        String s = "abciiidef";
//        String s ="weallloveyou";
//        int k = 7;

        /*
        int countVowels=0;
        for(int i=0 ;i<s.length();i++) {
            int f_count=0;
            for(int j=i; j<i+k && j<s.length() ;j++) {
                if((s.charAt(j) == 'a' || s.charAt(j) == 'e' ||s.charAt(j) == 'i' ||
                        s.charAt(j) == 'o' ||s.charAt(j) == 'u')){

                    f_count++;
                }
            }
            countVowels = Math.max(countVowels,f_count);
        }

        System.out.println(countVowels);


         */

//        int i=0;
//        int j=i+k;
//
//        int countVowels=0;
//        while(i<s.length() && j<=s.length()){
//            int x = i;
//            int countSub=0;
//            while(x<j) {
//                if((s.charAt(x) == 'a' || s.charAt(x) == 'e' ||s.charAt(x) == 'i' ||
//                        s.charAt(x) == 'o' ||s.charAt(x) == 'u')){
//                    countSub++;
//                }
//                x++;
//            }
//            countVowels = Math.max(countVowels,countSub);
//            i++;
//            j++;
//        }
//
//        System.out.println(countVowels);
    }
}
