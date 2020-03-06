package com.bengodwinweb.Paths;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        try {
            Path fileToDelete = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
            Files.delete(fileToDelete);


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
}
