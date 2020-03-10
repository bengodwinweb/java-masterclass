package com.bengodwinweb;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red RidingHood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

//        System.out.println("Employees over 30:");
//        employees.forEach(employee -> {
//            if(employee.getAge() > 30) System.out.println(employee.getName());
//        });
//
//        System.out.println("\nEmployees 30 and younger:");
//        employees.forEach(employee -> {
//            if(employee.getAge() <= 30) System.out.println(employee.getName());
//        });

        System.out.println("Employees 25 and younger:");
//        employees.stream()
//                .filter(employee -> employee.getAge() > 25)
//                .forEach(employee -> System.out.println(employee.getName()));

        IntPredicate intp = i -> i < 25;
        employees.stream()
                .filter(employee -> intp.test(employee.getAge()))
                .forEach(employee -> System.out.println(employee.getName()));

        System.out.println();

        // Suppliers
        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for(int i=0; i<10; i++) {
            System.out.println(randomSupplier.get());
        }

        System.out.println();

//        Function<Employee, String> getLastName = (Employee employee) ->
//                employee.getName().substring(employee.getName().indexOf(' ') + 1);
//        employees.forEach(employee -> System.out.println(getLastName.apply(employee)));
        employees.forEach(employee -> System.out.println(employee.getName().substring(employee.getName().indexOf(' ') + 1)));

        System.out.println();

//        employees.forEach(employee -> employee.getName().substring(employee.getName().indexOf(' ') + 1));
        employees.stream()
                .map(employee -> employee.getName().substring(employee.getName().indexOf(' ') + 1).toUpperCase())
                .forEach((String s) -> System.out.println(s));
    }
}