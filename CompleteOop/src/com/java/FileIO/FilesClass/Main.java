package com.java.FileIO.FilesClass;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        Path startingPath = Path.of("."); //cwd
        FileVisitor<Path> statsVisitor = new StatsVisitor(1);

        //Path walkFileTree(Path start, FileVisitor<? super Path> visitor)
        try {
            Files.walkFileTree(startingPath, statsVisitor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class StatsVisitor extends SimpleFileVisitor<Path> {

        // print all the levels of dir
        /*
           Ex:
           src
              com
                java
                    Collection
                        ArrayListDemo.java
                        Arrays
                            ArraysAsListExample.java
                            ArraysSearchExample.java
                            ArraysSortExample.java
         */


//        private int level;

        // print path level name and its accumulative size
        /*
        Ex:  [com] - 314,521 bytes
                [java] - 314,521 bytes
                    [Collection] - 25,689 bytes
                        [Arrays] - 3,118 bytes
                        [Collections] - 4,232 bytes
         */


        // summarize the number of Files in a directory
        // include the number odf sub folders


        private Path initialPath = null;
        private final Map<Path, Long> folderSize = new LinkedHashMap<>(); // to maintain insertion order
        private int initialCount;
        private int printLevel;

        // goto: -> start the code with preVisitDirectory()


        public StatsVisitor(int printLevel) {
            this.printLevel = printLevel;
        }


        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

            Objects.requireNonNull(file);
            Objects.requireNonNull(attrs);

            // get all the file names
//            System.out.println("\t".repeat(level+1) + file.getFileName());


            // get the size from parent, if not there initialize with 0 else
            // if already exist add to the attrs size to the old value
            folderSize.merge(file.getParent(), 0L,
                    (oldVal, newVal) -> oldVal += attrs.size());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            Objects.requireNonNull(dir);
            Objects.requireNonNull(attrs);

//            level++;
            //get all dir
//            System.out.println("\t".repeat(level) + dir.getFileName());


            // This is the entry point

            // for first time set initialPath to dir
            if (initialPath == null) {
                initialPath = dir;
                // get the level from root
                initialCount = dir.getNameCount();
            }

            // get map initialized
            else { // initial path is there
                // get the relative path level
                int relativeLevel = dir.getNameCount() - initialCount;

                // if relative path is 1 ,clear the map
                if (relativeLevel == 1) {
                    folderSize.clear();
                }

                // set size 0
                folderSize.put(dir, 0L);
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            Objects.requireNonNull(dir);
//            if (exc != null)
//                throw exc;
//            level--;

            // check if current dir is the initial path
            // if yes, terminate the process and end walk as the level is done
            if (dir.equals(initialPath)) {
                return FileVisitResult.TERMINATE;
            }

            // get the relative level
            int relativeLevel = dir.getNameCount() - initialCount;

            // if relative level is 1 , then we are in the 1st sub folder
            if (relativeLevel == 1) {
                // print the collected data
                folderSize.forEach((key, value) -> {
                    // get level of each sub folder
                    int level = key.getNameCount() - initialCount - 1;

                    if (level < printLevel) {
                        // print the indent by [folder_name] - accumulativeSize_of_folder
                        System.out.printf("%s[%s] - %,d bytes %n",
                                "\t".repeat(level), key.getFileName(), value);


                    }
                });
            }

            // if not the first level
            else {
                // get the folder size of the current dir
                long sizeOfFolder = folderSize.get(dir);
                // merge all the data with parent
                folderSize.merge(dir.getParent(), 0L, (o, n) -> o += sizeOfFolder);
            }

            return FileVisitResult.CONTINUE;
        }
    }
}
