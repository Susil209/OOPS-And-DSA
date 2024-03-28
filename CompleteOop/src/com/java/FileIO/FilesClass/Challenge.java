package com.java.FileIO.FilesClass;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Challenge {
    public static void main(String[] args) {

        Path startingPath = Path.of("./CompleteOop/src/com/java/"); //cwd
        FileVisitor<Path> statsVisitor = new StatsVisitor(Integer.MAX_VALUE);

        //Path walkFileTree(Path start, FileVisitor<? super Path> visitor)
        try {
            Files.walkFileTree(startingPath, statsVisitor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class StatsVisitor implements FileVisitor<Path> {


        // Challenge
        // summarize the number of Files in a directory
        // include the number odf sub folders

        private Path initialPath = null;

        // The outer Map takes another Map(inner) as a value for hold file size in bytes
        // count of all files and folders
        private final Map<Path, Map<String, Long>> folderSize = new LinkedHashMap<>(); // to maintain insertion order
        private int initialCount;

        // goto: -> start the code with preVisitDirectory()
        private int printLevel;

        // count of dir and sub folders
        private static final String DIR_CNT = "DirCount";
        // accumulated file size
        private static final String FILE_SIZE = "fileSize";
        // no of files in the folders
        private static final String FILE_CNT = "fileCount";


        // goto: -> start the code with preVisitDirectory()


        public StatsVisitor(int printLevel) {
            this.printLevel = printLevel;
        }


        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

            Objects.requireNonNull(file);
            Objects.requireNonNull(attrs);


            //get the nested file map

            //get the parent folder's map
            var parentMap = folderSize.get(file.getParent());

            //check for null
            if (parentMap != null) {
                long fileSize = attrs.size();
                parentMap.merge(FILE_SIZE, fileSize, (o, n) -> o += n);
                parentMap.merge(FILE_CNT, 1L, Math::addExact); // return sum of its args
            }

            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            Objects.requireNonNull(file);
            if (exc != null) {
                System.out.println(exc.getClass().getSimpleName() + " " + file);
            }
            return FileVisitResult.CONTINUE;
        }

        //create an entry point for every dir
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            Objects.requireNonNull(dir);
            Objects.requireNonNull(attrs);

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
                folderSize.put(dir, new HashMap<>());
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
                        long size = value.getOrDefault(FILE_SIZE, 0L);
                        // print the indent by [folder_name] - accumulativeSize_of_folder bytes, no_of_files, no_of_folders
                        System.out.printf("%s[%s] - %,d bytes, %d files, %d folders %n",
                                "\t".repeat(level), key.getFileName(), size,
                                value.getOrDefault(FILE_CNT, 0L),
                                value.getOrDefault(DIR_CNT, 0L)
                        );
                    }


                });
            }

            // if not the first level
            else {
                // get the parent's data
                var parentMap = folderSize.get(dir.getParent());
                var childMap = folderSize.get(dir);

                // get folder count, if not present then return 0
                long folderCount = childMap.getOrDefault(DIR_CNT, 0L);
                long fileSize = childMap.getOrDefault(FILE_SIZE, 0L);
                long fileCount = childMap.getOrDefault(FILE_CNT, 0L);

                //merge with parent map
                parentMap.merge(DIR_CNT, folderCount + 1, (o, n) -> o += n);
                parentMap.merge(FILE_SIZE, fileSize, Math::addExact);
                parentMap.merge(FILE_CNT, fileCount, Math::addExact);

            }

            return FileVisitResult.CONTINUE;
        }
    }
}
