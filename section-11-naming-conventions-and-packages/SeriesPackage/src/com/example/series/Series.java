package com.example.series;

import java.util.ArrayList;

public class Series {
    public static int nSum(int n) {
        return (n * (n + 1)) / 2;
    }

    public static int factorial(int n) {
        if (n < 0) return -1;
        if (n == 0) return 0;
        int product = 1;
        for (int i = 2; i <= n; i++) {
            product *= i;
        }
        return product;
    }

    public static int fibonacci(int n) {
        if (n < 0) return -1;
        if (n == 0) return 0;
        if (n == 1) return 1;

        int n1 = 0;
        int n2 = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = n1 + n2;
            n1 = n2;
            n2 = fib;
        }
        return fib;
    }
}
