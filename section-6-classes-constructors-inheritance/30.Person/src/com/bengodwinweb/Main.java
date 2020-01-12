package com.bengodwinweb;

public class Main {

    public static void main(String[] args) {
        Person person = new Person();
        person.setFirstName("");
        person.setLastName("");
        person.setAge(10);
        System.out.println("fullName= " + person.getFullName()); // fullName=
        System.out.println("teen= " + person.isTeen()); // false
        person.setFirstName("John");
        person.setAge(18);
        System.out.println("fullName= " + person.getFullName()); // John
        System.out.println("teen= " + person.isTeen()); // true
        person.setLastName("Smith");
        System.out.println("fullName= " + person.getFullName()); // John Smith
    }
}
