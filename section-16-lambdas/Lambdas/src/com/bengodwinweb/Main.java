package com.bengodwinweb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        // Same code using implementation, anonymous class, and lambda
//
//        new Thread(new CodeToRun()).start();
//
//        // Anonymous
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Printing from the anonymous Runnable");
//            }
//        }).start();
//
//        // Lambda
//        new Thread(() -> System.out.println("Printing from the lambda Runnable")).start();

        // Lambda with code block
        new Thread(() -> {
            System.out.println("Printing from the lambda with code block Runnable");
            System.out.println("Still in the lambda woo\n");
        }).start();


        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        for(Employee employee : employees) {
            System.out.println(employee.getName());
        }
        System.out.println();

        // Sort employees list without lambda
//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

        // Sort employees list with lambda
        Collections.sort(employees, (Employee e1, Employee e2) ->
                e1.getName().compareTo(e2.getName()));

        // Best implementation using Comparator.comparing()
//        Collections.sort(employees, Comparator.comparing(Employee::getName).thenComparing(Employee::getAge));

        for(Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }
}

class CodeToRun implements Runnable {
    @Override
    public void run() {
        System.out.println("Printing from the codeToRun Runnable");
    }
}
