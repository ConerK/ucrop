package com.example.myapplication;

import java.util.ArrayList;

public class Vertex {
    private int data = 0;
    private int index = 0;
    private ArrayList<Edge> edges = new ArrayList<>();
    private boolean visited = false;

    protected void addEdge(Edge edge){
        edges.add(edge);
    }

}
