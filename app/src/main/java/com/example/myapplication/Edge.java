package com.example.myapplication;

public class Edge {
    private Vertex from;
    private Vertex to;

    public Edge(Vertex from, Vertex to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    private double weight = 0.0;

}
