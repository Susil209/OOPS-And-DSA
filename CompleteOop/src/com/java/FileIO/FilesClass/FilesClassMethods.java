package com.java.FileIO.FilesClass;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.stream.Stream;

public class FilesClassMethods {
    public static void main(String[] args) {
        Path path = Path.of("");
        System.out.println("cwd = "+ path.toAbsolutePath()); // cwd = C:\Users\KIIT\JavaProjects\OOPS

        try(Stream<Path> paths = Files.list(path)) {
//            paths.forEach(System.out::println);
            paths
                    .map(FilesClassMethods::listDir)
                    .forEach(System.out::println);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        /*
            .idea
            CompleteOop
            files
            nested
            OOPS.iml
            out
         */

        System.out.println("---------------------------------");
        // walk(), maxDepth = 0 to Integer.MAX_VALUE
        try(Stream<Path> paths = Files.walk(path,2)) {

            paths
                    .filter(Files::isRegularFile)
                    .map(FilesClassMethods::listDir)
                    .forEach(System.out::println);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        System.out.println("---------------------------------");

        // find() , it is more efficient than using filter() method in walk
        try(Stream<Path> paths = Files.find(path, 2 ,
//                (p,attr)->Files.isRegularFile(p)))  //using Path path
                (p,attr)-> attr.isRegularFile()))   // using BasicFileAttribute attr
        {
            paths
                    .map(FilesClassMethods::listDir)
                    .forEach(System.out::println);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        System.out.println("------------------------------------------");

        //To get through all the nested files and print the file size > 3000
        try(Stream<Path> paths = Files.find(path, Integer.MAX_VALUE ,
                (p,attr)-> attr.isRegularFile() && attr.size() > 3000
        )) {
            paths
                    .map(FilesClassMethods::listDir)
                    .forEach(System.out::println);
        }catch (IOException e){
            throw new RuntimeException(e);
        }


        // newDirectoryStream(Path path)
        System.out.println("============Directory Stream==============");
        try (var dirs = Files.newDirectoryStream(path)){
            dirs.forEach(d -> System.out.println(FilesClassMethods.listDir(d)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("--------------------------------------------");
        // newDirectoryStream(Path path, String glob)
        // To get all files that ends with .xml inside .idea directory
        path = path.resolve(".idea");
        try (var dirs = Files.newDirectoryStream(path,"*.xml")){
            dirs.forEach(d -> System.out.println(FilesClassMethods.listDir(d)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("--------------------------------------------");
        // newDirectoryStream(Path dir, DirectoryStream.Filter<? super Path> filter)
        // To get all files that ends with .xml inside .idea directory
        // and size > 8000
        try (var dirs = Files.newDirectoryStream(path,
                p -> p.getFileName().toString().endsWith(".xml")
                        && Files.isRegularFile(p) && Files.size(p) > 8000L
                )){
            dirs.forEach(d -> System.out.println(FilesClassMethods.listDir(d)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String listDir(Path path){
        try{
            boolean isDir = Files.isDirectory(path);
            FileTime dateField = Files.getLastModifiedTime(path);
            LocalDateTime modDT = LocalDateTime.ofInstant(
                    dateField.toInstant(), ZoneId.systemDefault());

            return "%tD %tT %-5s %12s %s".formatted(modDT, modDT,
                    (isDir ? "<DIR>" : ""), (isDir ? "" : Files.size(path)), path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
