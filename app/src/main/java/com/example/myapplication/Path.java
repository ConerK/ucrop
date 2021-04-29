package com.example.myapplication;

public class Path {
    private int start;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public double getValue() {
        return value;
    }

    private int end;
    private double value;

    public Path(int start, int end, double value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
}
