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

        employees.forEach(employee -> {
            System.out.printf("%s, %s%n", employee.getName(), employee.getAge());
        });

//        for(Employee employee : employees) {
//            System.out.println(employee.getName());
//            new Thread(() -> System.out.println(employee.getAge())).start();
//        }
//        System.out.println();



        // Sort employees list without lambda
//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

        // Sort employees list with lambda
        Collections.sort(employees, (e1, e2) ->
                e1.getName().compareTo(e2.getName()));

        // Best implementation using Comparator.comparing()
//        Collections.sort(employees, Comparator.comparing(Employee::getName).thenComparing(Employee::getAge));

//        for(Employee employee : employees) {
//            System.out.println(employee.getName());
//        }
//        System.out.println();

//        String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        },
//                employees.get(0).getName(), employees.get(1).getName());
//
//        String sillyString = doStringStuff((s1, s2) -> s1.toUpperCase() + s2.toUpperCase(),
//                employees.get(0).getName(),
//                employees.get(1).getName());
//
//        System.out.println(sillyString);

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
            return uc.upperAndConcat(s1, s2);
    }
}

class CodeToRun implements Runnable {
    @Override
    public void run() {
        System.out.println("Printing from the codeToRun Runnable");
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {

    public String doSomething() {
        System.out.println("the AnotherClass class name is: " + getClass().getSimpleName());
        return Main.doStringStuff((s1, s2) -> {
            System.out.println("the anonymous class name is: " + getClass().getSimpleName());
            return s1.toUpperCase() + s2.toUpperCase();
        }, "String1", "String2");
    }
}
