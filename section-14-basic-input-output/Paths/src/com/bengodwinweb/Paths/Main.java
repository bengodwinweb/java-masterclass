package com.bengodwinweb.Paths;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001b[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_BRIGHT_RED = "\u001b[31;1m";

    public static void main(String[] args) {
        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);

        Path directory = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        try(DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {
            for(Path file : contents) {
                System.out.println("File: " + ANSI_BLUE + file.getFileName() + ANSI_RESET + ", Created at: " + ANSI_GREEN + (formatFileTime((FileTime) Files.getAttribute(file, "creationTime"))) + ANSI_RESET);
            }
        } catch (IOException | DirectoryIteratorException e) {
            System.out.println("IOException: " + e.getMessage());
        }

//        String separator = File.separator;
//        System.out.println(separator);
//        separator = FileSystems.getDefault().getSeparator();
//        System.out.println(separator);
//
//        try {
//            Path tempFile = Files.createTempFile("myapp", ".appext");
//            System.out.println("Temporary file path = " + tempFile.toAbsolutePath());
//        } catch (IOException e) {
//            System.out.println("IOException: " + e.getMessage());
//        }

//        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
//        for(FileStore store : stores) {
//            System.out.println("\nVolume Name/Drive letter: " + ANSI_GREEN + store + ANSI_RESET);
//            System.out.println(store.name());
//        }

//        System.out.println("**********************");
//        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
//        for(Path path : rootPaths) {
//            System.out.println(path);
//        }

        System.out.println(ANSI_BLUE + "\n------Walking Tree for Dir2-------" + ANSI_RESET);
        Path dir2Path = FileSystems.getDefault().getPath("FileTree", "Dir2");
        try {
            Files.walkFileTree(dir2Path, new PrintNames());
        } catch (IOException e) {
            System.out.println(ANSI_BRIGHT_RED + "IOException: " + ANSI_RESET + e.getMessage());
        }

        System.out.println("\n------Copying Dir2 to Dir4/Dir2Copy-------");
        Path copyPath = FileSystems.getDefault().getPath("FileTree", "Dir4", "Dir2Copy");
        try {
            Files.walkFileTree(dir2Path, new CopyFiles(dir2Path, copyPath));
        } catch(IOException e) {
            System.out.println(ANSI_BRIGHT_RED + "IOException: " + ANSI_RESET + e.getMessage());
        }
    }

    public static String formatFileTime(FileTime time) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM d, yyyy h:mm:ss a");
        return time.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().format(dtf);
    }
}
