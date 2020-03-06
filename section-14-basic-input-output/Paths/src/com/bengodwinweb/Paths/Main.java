package com.bengodwinweb.Paths;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001b[32m";
    public static final String ANSI_BLUE = "\u001B[34m";


    public static void main(String[] args) {
//        DirectoryStream.Filter<Path> filter =
//                new DirectoryStream.Filter<Path>() {
//                    public boolean accept(Path path) throws IOException {
//                        return Files.isRegularFile(path);
//                    }
//                };

        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);

        Path directory = FileSystems.getDefault().getPath("FileTree", "Dir2");
        try(DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {
            for(Path file : contents) {
                System.out.println("File: " + ANSI_BLUE + file.getFileName() + ANSI_RESET + ", Created at: " + ANSI_GREEN + (formatFileTime((FileTime) Files.getAttribute(file, "creationTime"))) + ANSI_RESET);
            }
        } catch (IOException | DirectoryIteratorException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    public static String formatFileTime(FileTime time) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM d, yyyy h:mm:ss a");
        return time.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().format(dtf);
    }
}
