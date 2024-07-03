package com.abdoxm.xelops;

public class Cube {
    private int sideLength;

    public Cube(int sideLength) {
        if (sideLength < 0) {
            throw new IllegalArgumentException("Side length cannot be negative");
        }
        this.sideLength = sideLength;
    }

    public double getVolume() {
        return Math.pow(sideLength, 3);
    }

    public double getSurfaceArea() {
        return 6 * Math.pow(sideLength, 2);
    }
}

