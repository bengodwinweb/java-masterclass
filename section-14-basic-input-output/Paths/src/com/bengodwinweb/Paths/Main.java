package com.bengodwinweb.Paths;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        try {
//            Path fileToCreate = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Files.createFile(fileToCreate);

//            Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.createDirectory(dirToCreate);
//
//            Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir2/Dir3/Dir4/Dir5/Dir6");
//            Files.createDirectories(dirToCreate);

            Path filePath = FileSystems.getDefault().getPath("Examples", "Dir1", "file1.txt");
            System.out.println("Size = " + Files.size(filePath));
            System.out.println("Last modified = " + formatFileTime(Files.getLastModifiedTime(filePath)));

            BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("\nSize = " + attrs.size());
            System.out.println("Last modified = " + formatFileTime(attrs.lastModifiedTime()));
            System.out.println("Created = " + formatFileTime(attrs.creationTime()));
            System.out.println("Is directory = " + attrs.isDirectory());
            System.out.println("Is regular file = " + attrs.isRegularFile());


//            Path fileToDelete = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
//            Files.deleteIfExists(fileToDelete);
//
//            Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path destination = FileSystems.getDefault().getPath("Examples", "file2.txt");
//            Files.move(fileToMove, destination);
//
//            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
//
//            sourceFile = FileSystems.getDefault().getPath("Examples", "Dir1");
//            copyFile = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.copy(sourceFile, copyFile);
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
//        Path workingDirectoryPath = FileSystems.getDefault().getPath("WorkingDirectory.txt");
//        Path subdirectoryPath = Paths.get(".", "files", "Subdirectory.txt");
//        Path outTherePath = Paths.get(".", "..", "OutThere.txt");
//
//        System.out.println("====================");
//        System.out.println("WorkingDirectory.txt\n");
//        printFile(workingDirectoryPath);
//        System.out.println("====================\n");
//
//        System.out.println("====================");
//        System.out.println("Subdirectory.txt\n");
//        printFile(subdirectoryPath);
//        System.out.println("====================\n");
//
//        System.out.println("====================");
//        System.out.println("OutThere.txt\n");
//        printFile(outTherePath);
//        System.out.println("====================\n");
//
//        Path filePath = Paths.get(".", "notarealfile.txt");
//        System.out.println("Exists = " + Files.exists(filePath));
//    }
//
//    public static void printFile(Path path) {
//        try(BufferedReader fileReader = Files.newBufferedReader(path)) {
//            String line;
//            while((line = fileReader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch(IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }

    public static String formatFileTime(FileTime time) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM d, yyyy h:mm:ss a");
        return time.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().format(dtf);
    }
}
