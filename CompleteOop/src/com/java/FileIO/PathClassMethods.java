package com.java.FileIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;

public class PathClassMethods {
    public static void main(String[] args) {
//        Path path = Path.of("files/testing.txt");
        // multilevel folders
        Path path = Path.of("nested/level/folders/testing.txt");

//        printPathInfo(path);

        logStatements(path);
        extraInfo(path);
    }

    public static void printPathInfo(Path path) {
        System.out.println("Path: " + path);
        System.out.println("Filename = " + path.getFileName());
        System.out.println("Parent = " + path.getParent());
        Path absolutePath = path.toAbsolutePath();
        System.out.println("Absolute path = " + absolutePath);

        System.out.println("Absolute path root = " + absolutePath.getRoot());
        System.out.println("Root = " + path.getRoot()); // null, as it is not absolute path
        System.out.println("Is absolute? : " + path.isAbsolute()); // false

        // printing the full hierarchy
        System.out.println(path.toAbsolutePath().getRoot());
//        int i = 1;
//        var it = path.toAbsolutePath().iterator();
//        while (it.hasNext()) {
//            System.out.println(".".repeat(i++) + " " + it.next());
//        }

        int pathParts = absolutePath.getNameCount();
        for (int i = 0; i < pathParts; i++) {
            System.out.println(".".repeat(i+1)+" "+absolutePath.getName(i));
        }
    }

    private static void logStatements(Path path){
        try{
            // get the parent
            Path parent = path.getParent();
            // create directory if not exist
            if(!Files.exists(parent)) {
//                Files.createDirectory(parent);

                // for nested directories
                Files.createDirectories(parent);
                System.out.println("Directory is created!");
            }
            // write into file
            Files.writeString(path, Instant.now() + ": hello world\n",
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            // create new text in file , append text
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //getting all info about file
    private static void extraInfo(Path path){
        try {
            var attr = Files.readAttributes(path, "*");
            attr.entrySet().forEach(System.out::println);
        }catch (IOException e){
            System.out.println("Problem getting attributes.");
        }
    }

    /*
    lastAccessTime=2024-01-22T14:49:51.2856172Z
    lastModifiedTime=2024-01-22T14:49:51.2856172Z
    size=88
    creationTime=2024-01-22T14:44:06.2638781Z
    isSymbolicLink=false
    isRegularFile=true
    fileKey=null
    isOther=false
    isDirectory=false
     */
}
