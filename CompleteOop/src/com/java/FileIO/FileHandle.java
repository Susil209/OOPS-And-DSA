package com.java.FileIO;

import java.io.File;
import java.io.IOException;

public class FileHandle {
    public static void main(String[] args) throws IOException {
        File f = new File("test.txt");
        System.out.println(f.exists()); //false for first time execution

        //create a new file
        if (f.createNewFile())
            System.out.println("File created");
        else
            System.out.println("File already exists");

        System.out.println(f.exists()); //true

        File f1 = new File("TestDir");

        if (f1.mkdir()) {

            // display that the directory is created
            // as the function returned true
            System.out.println("Directory is created");
        } else {
            // display that the directory cannot be created
            // as the function returned false
            System.out.println("Directory cannot be created");
        }

        // cwd
        System.out.println("Current working directory " + new File("").getAbsolutePath());
        // Current working directory C:\Users\KIIT\JavaProjects\OOPS

        // get the root directory
        for (File f2 : File.listRoots()) {
            System.out.println(f2); // C:\  D:\
        }

        System.out.println("--------------------------------");

        int count = 0;
        File f3 = new File("C:\\Windows");

        // display all in Windows dir
        String[] s = f3.list();
        if (s != null) {
            for (String s1 : s) {
                count++;
                System.out.println(s1);
            }


        }

        System.out.println("Total file list = " + count);

        System.out.println("----------------------------------");

        int fCount = 0;
        // display only files
        if (s != null) {
            for (String s1 : s) {
                File f4 = new File(f3, s1);
                if (f4.isFile()) {
                    fCount++;
                    System.out.println(s1);
                }
            }
        }

        System.out.println("Only files present = "+fCount);

    }

}
