package com.conorshipsey.colourtableca3;

import java.util.HashMap;

public class ColourTable {
    private final int numPalettes;
    private final HashMap<String, Colour> tableDictionary;

    public ColourTable(int numPalettes) {
        // if num palettes is a power of 2 & greater than 1 & less than 1025
        if (numPalettes > 1 && numPalettes < 1025 && (isPowerOfTwo(numPalettes))) {
            this.numPalettes = numPalettes;
        }
        else {
            throw new IllegalArgumentException("Invalid palette size");
        }
        this.tableDictionary = new HashMap<>();
    }

    private static boolean isPowerOfTwo(int num) {
        if (num <= 0) {
            return false;  // 0 and negative numbers are not powers of two
        }
        // Check if the logarithm to the base 2 is an integer
        double logBase2 = Math.log(num) / Math.log(2);
        return Math.floor(logBase2) == logBase2;
    }

    public Colour add(String hexValue) {
        // Ensuring that the colour table is not full
        if (tableDictionary.size() >= numPalettes) {
            throw new IllegalArgumentException("Colour table is full");
        }
        // ensuring validity of hexadecimal RGB colour added
        if (!isValidHex(hexValue)) {
            throw new IllegalArgumentException("Invalid hex value");
        }
        if (tableDictionary.containsKey(hexValue)) {
            throw new IllegalArgumentException("Colour is already present in table");
        }
        int colour = Integer.parseInt(hexValue, 16);
        tableDictionary.put(hexValue, new Colour(colour, hexValue));

        return new Colour(colour, hexValue);
    }

    public Colour remove(String hexValue) {
        // Ensuring that the colour table is not empty
        if (tableDictionary.size() == 0) {
            throw new IllegalArgumentException("Colour table is empty");
        }
        if (!tableDictionary.containsKey(hexValue)) {
            throw new IllegalArgumentException("Colour is not present in table");
        }
        Colour removed_colour = tableDictionary.get(hexValue);
        tableDictionary.remove(hexValue);
        return removed_colour;
    }

    private boolean isValidHex(String hexValue) {
        // Check if the string is a valid hexadecimal representation
        /*
        We expect the string to be a valid hexadecimal representation if:
            - it contains only the characters 0-9 and a-f (case insensitive)
            - it is exactly 6 characters long
         */
        return hexValue.matches("[0-9a-fA-F]+") && hexValue.length() == 6;
    }

    public boolean isPresent(String hexValue) {
        // Check if the colour is present in the colour table
        return tableDictionary.containsKey(hexValue);
    }

    public int getNumPalettes() {
        return numPalettes;
    }

    public class Colour {
        private final int colour;
        private final String hexColour;

        public Colour(int colour, String hexColour) {
            this.colour = colour;
            this.hexColour = "0x" + hexColour;
        }

        public int getColour() {
            return colour;
        }

        public String getHexColour() {
            return hexColour;
        }
    }
}
