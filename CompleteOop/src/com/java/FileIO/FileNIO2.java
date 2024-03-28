package com.java.FileIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileNIO2 {

    // using java.io.file
    public static void useFile(String fileName) {

        File file = new File(fileName);
        boolean isFileExist = file.exists();

        System.out.printf("File '%s' %s\n", fileName, isFileExist ? "exists." : "doesn't exist.");

        if (isFileExist) {
            System.out.println("Deleting file: " + fileName);
            isFileExist = !file.delete();
        }

        if (!isFileExist) {
            try {
                file.createNewFile(); // returns boolean
            } catch (IOException e) {
                System.out.println("Something went wrong.");
            }

            System.out.println("Creating file : " + fileName);
            if (file.canWrite()) {
                System.out.println("Would write to file here.");
            }
        }

    }

    // Using java.nio.file
    public static void usePath(String fileName) {

        Path path = Path.of(fileName);
        boolean isFileExist = Files.exists(path);

        System.out.printf("File '%s' %s\n", fileName, isFileExist ? "exists." : "doesn't exist.");

        if (isFileExist) {
            System.out.println("Deleting file: " + fileName);
            try {
                // isFileExist = !Files.deleteIfExists(path);
                // or
                Files.delete(path);
                isFileExist = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!isFileExist) {
            try {
                Files.createFile(path);// returns 'Path'
                System.out.println("Creating file : " + fileName);
                if (Files.isWritable(path)) {
                    System.out.println("Would write to file here.");
                    // write char seq in the file
                    Files.writeString(path, """
                            Here are some text to test
                            Files write file method,
                            written on date 21-01-2024.
                            """);
                }
                System.out.println("And I can read too.");
                System.out.println("--------------------------");
                //read all line from the file
                Files.readAllLines(path).forEach(System.out::println);
            } catch (IOException e) {
                System.out.println("Something went wrong.");
            }


        }


    }

    public static void main(String[] args) {

        useFile("testFile.txt");
        usePath("pathName.txt");

        /*
        File f = new File("test.txt");
        System.out.println(f.getAbsolutePath());

        if (!f.exists())
            System.out.println("Can't run this file until it is created.");
        else
            System.out.println("I am good.");



        Path path = Paths.get("test.txt");

        if (!Files.exists(path))
            System.out.println("2. Can't run this file until it is created.");
        else
            System.out.println("2. I am good.");


         */

    }
}
