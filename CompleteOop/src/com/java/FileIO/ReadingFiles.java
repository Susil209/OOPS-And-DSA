package com.java.FileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFiles {
    public static void main(String[] args) {
    /*
        try(FileReader reader = new FileReader("file.txt")) {
            int data;
            while((data=reader.read()) != -1){
                //System.out.println(data); // char in java prints unsigned integer

                // to get the character value, wrap it with Character class
                // or use type casting to (char)
                System.out.println((char)data);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

     */

        try(FileReader reader = new FileReader("file.txt")) {
            char[] block = new char[1000];
            int data;
            while((data=reader.read(block)) != -1){
                String content = new String(block, 0, data);
                System.out.printf("--> [%d chars] %s%n", data, content);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("--------BufferedReader---------");
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("file.txt"))) {
//            String line;
//            while((line = bufferedReader.readLine()) != null){
//                System.out.println(line);
//            }

            //or, since JDK 1.8
            bufferedReader.lines().forEach(System.out::println);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
