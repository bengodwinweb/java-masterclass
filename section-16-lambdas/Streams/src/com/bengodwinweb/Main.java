package com.bengodwinweb;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> bingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49",
                "G60", "g50",
                "I26", "I17",
                "I29", "O71"
        );

        bingoNumbers.stream()
                .filter(number -> number.substring(0, 1).equalsIgnoreCase("G"))
                .forEach(number -> System.out.println(number.toUpperCase()));
        // Print bingoNumbers in G row

        System.out.println();

        // Add bingoNumbers in G row to list
        List<String> gNumbers = bingoNumbers.stream()
                .filter(s -> s.startsWith("G") || s.startsWith("g"))
                .map(String::toUpperCase)
                .sorted()
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println();

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29");

        List<String> inoNumbers = Stream.concat(ioNumberStream, inNumberStream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        inoNumbers.forEach(System.out::println);
    }
}
