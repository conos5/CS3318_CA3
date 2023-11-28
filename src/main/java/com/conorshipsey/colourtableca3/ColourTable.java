package com.conorshipsey.colourtableca3;

public class ColourTable {
    private final int numPalettes;

    public ColourTable(int numPalettes) {
        // if num palettes is a power of 2 & greater than 1 & less than 1025
        if (numPalettes > 1 && numPalettes < 1025 && (isPowerOfTwo(numPalettes))) {
            this.numPalettes = numPalettes;
        }
        else {
            throw new IllegalArgumentException("Invalid palette size");
        }
    }
    public static boolean isPowerOfTwo(int num) {
        if (num <= 0) {
            return false;  // 0 and negative numbers are not powers of two
        }
        // Check if the logarithm to the base 2 is an integer
        double logBase2 = Math.log(num) / Math.log(2);
        return Math.floor(logBase2) == logBase2;
    }
}
