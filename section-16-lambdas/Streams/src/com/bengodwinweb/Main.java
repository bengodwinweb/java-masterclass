package com.bengodwinweb;

import java.util.ArrayList;
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
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        inoNumbers.forEach(System.out::println);

        System.out.println();

        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Deer", 25);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        Department hr = new Department("Human Resources");
        Stream.of(jane, jack, snow).forEach(hr::addEmployee);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = Stream.of(hr, accounting).collect(Collectors.toList());

        List<Employee> allEmployees = departments.stream()
                .flatMap(d -> d.getEmployees().stream())
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.print("\nYoungest employee is: ");
        allEmployees.stream()
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);
    }
}
