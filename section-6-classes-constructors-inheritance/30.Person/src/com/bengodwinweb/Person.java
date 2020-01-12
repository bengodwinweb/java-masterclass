package com.bengodwinweb;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = (age >= 0 && age <= 100) ? age : 0;
    }

    public boolean isTeen() {
        return (this.age > 12 && this.age < 20);
    }

    public String getFullName() {
        if (this.firstName.length() > 0) {
            return (this.lastName.length() > 0) ? this.firstName + " " + this.lastName : this.firstName;
        } else if (this.lastName.length() > 0) {
            return this.lastName;
        }
        return "";
    }
}
