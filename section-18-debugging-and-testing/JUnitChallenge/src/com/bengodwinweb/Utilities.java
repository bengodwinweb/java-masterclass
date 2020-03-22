package com.bengodwinweb;

public class Utilities {

    // Returns a char array containing every nth char. When
    // sourceArray.length < n, returns sourceArray
    public static char[] everyNthChar(char[] sourceArray, int n) {

        if (sourceArray == null || sourceArray.length < n) return sourceArray;

        int returnedLength = sourceArray.length / n;
        char[] result = new char[returnedLength];
        int index = 0;

        for (int i = n - 1; i < sourceArray.length; i += n) {
            result[index++] = sourceArray[i];
        }

        return result;
    }

    // Removes pairs of the same character that are next to each other
    public static String removePairs(String source) {
        if (source == null || source.length() < 2) return source;

        StringBuilder sb = new StringBuilder();
        char[] string = source.toCharArray();

        for (int i = 0; i < string.length - 1; i++) {
            if (string[i] != string[i + 1]) {
                sb.append(string[i]);
            }
        }
        sb.append(string[string.length - 1]);

        return sb.toString();
    }

    // perform a conversion based on some internal business rule.
    public static int converter(int a, int b) {
        return (a / b) + (a * 30) - 2;
    }

    public static String nullIfOddLength(String source) {
        return (source.length() % 2 == 0) ? source : null;
    }
}
