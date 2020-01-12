package com.bengodwinweb;

public class Main {

    public static void main(String[] args) {
	    ComplexNumber one = new ComplexNumber(1.0, 1.0);
	    ComplexNumber number = new ComplexNumber(2.5, -1.5);
	    one.add(1, 1);
        System.out.println("one.real= " + one.getReal()); // 2.0
        System.out.println("one.imaginary= " + one.getImaginary()); // 2.0
        one.subtract(number);
        System.out.println("one.real= " + one.getReal()); // -0.5
        System.out.println("one.imaginary= " + one.getImaginary()); // 3.5
        number.subtract(one);
        System.out.println("number.real= " + number.getReal()); // 3.0
        System.out.println("number.imaginary= " + number.getImaginary()); // -5.0
    }
}
