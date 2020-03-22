package com.bengodwinweb;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    @org.junit.jupiter.api.Test
    void everyNthChar() {
        char[] hello = new char[]{'h', 'e', 'l', 'l', 'o'};
        assertArrayEquals(hello, Utilities.everyNthChar(hello, 6), "Should return input when n is greater than input length");
        assertArrayEquals(new char[]{'e', 'l'}, Utilities.everyNthChar(hello, 2));
    }

    @org.junit.jupiter.api.Test
    void removePairs() {
        assertEquals("ABCDEF", Utilities.removePairs("ABCDEF"), "Should return string if no pairs");
        assertEquals("ABCDEF", Utilities.removePairs("ABCDEFF"), "Should remove pair at end of string");
        assertEquals("ABCABDEF", Utilities.removePairs("AABCABDEF"), "Should remove pair at beginning of string");
        assertEquals("ABCABDEF", Utilities.removePairs("ABCCABDEEF"), "Should remove internal pairs");
        assertEquals("A", Utilities.removePairs("A"), "Should return input when input.length is less than 2");
        assertEquals("", Utilities.removePairs(""), "Should return an empty string when input is an empty string");
        assertNull(Utilities.removePairs(null), "Should return null when input is null");
    }

    @org.junit.jupiter.api.Test
    void converter() {
        assertEquals(300, Utilities.converter(10, 5));
        assertThrows(ArithmeticException.class, () -> Utilities.converter(10, 0), "Should throw ArithmeticException when denominator is 0");
    }

    @org.junit.jupiter.api.Test
    void nullIfOddLength() {
        assertNull(Utilities.nullIfOddLength("odd"), "Should return null if string if of odd length");
        assertEquals("even", Utilities.nullIfOddLength("even"), "Should return string if even length");
    }
}