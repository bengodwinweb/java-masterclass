package com.bengodwinweb.Paths;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyFiles extends SimpleFileVisitor<Path> {
    private Path sourceRoot;
    private Path targetRoot;

    public CopyFiles(Path sourceRoot, Path targetRoot) {
        this.sourceRoot = sourceRoot;
        this.targetRoot = targetRoot;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path relativizedPath = sourceRoot.relativize(dir);
        Path copyDir = targetRoot.resolve(relativizedPath);
        System.out.println("Copying dir " + Main.ANSI_GREEN + (!relativizedPath.toString().equals("") ? relativizedPath : "root") + Main.ANSI_RESET + " to " + Main.ANSI_GREEN + copyDir + Main.ANSI_RESET);
        try {
            Files.copy(dir, copyDir);
        } catch (IOException e) {
            System.out.println(Main.ANSI_BRIGHT_RED + "Error copying dir: " + Main.ANSI_RESET + e.getMessage());
            return FileVisitResult.SKIP_SUBTREE;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path relativizedPath = sourceRoot.relativize(file);
        Path copyFile = targetRoot.resolve(relativizedPath);
        System.out.println("\tCopying file " + Main.ANSI_BLUE +  relativizedPath + Main.ANSI_RESET + " to " + Main.ANSI_BLUE + copyFile + Main.ANSI_RESET);
        try {
            Files.copy(file, copyFile);
        } catch (IOException e) {
            System.out.println(Main.ANSI_BRIGHT_RED + "Error copying file: " + Main.ANSI_RESET + e.getMessage());
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println(Main.ANSI_BRIGHT_RED + "Error accessing file: " + Main.ANSI_RESET + file.toAbsolutePath() + " " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }
}
