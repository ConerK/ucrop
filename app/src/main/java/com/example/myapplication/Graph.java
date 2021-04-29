package com.example.myapplication;

import java.util.*;

public class Graph {
    private ArrayList vertexList;
    private double[][] edges;
    private boolean[] isVisited;
    private List<Path> pathList;

    private static class GraphSingle{
        private static Graph INSTANCE = new Graph();
    }
    public static Graph getinstance(){
        return GraphSingle.INSTANCE;
    }

    public Graph() {
        pathList = new ArrayList<>();
        edges = new double[8][8];
        isVisited = new boolean[8];
        vertexList = new ArrayList();
    }

    public void addVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void addEdges(int from, int to, double weight) {
        edges[from][to] = weight;
        edges[to][from] = 1 / weight;
    }

    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    public Object getValueByIndex(int i) {
        return vertexList.get(i);
    }

    private double bfs(boolean[] isVisited, int from, int to) {
        double result = 0;
        int line, row;
        LinkedList queue = new LinkedList();
        isVisited[from] = true;
        queue.addLast(from);
        System.out.print("about=== " + from);
        while (!queue.isEmpty()) {
            line = ((Integer) queue.removeFirst()).intValue();
            row = getFirstNeighbor(line);
            System.out.print("Line::: " + vertexList.get(line) + "  ");
            while (row != -1) {
                if (!isVisited[row]) {
                    System.out.print("Row: " + getValueByIndex(row));
                    if (row == to) {
                        System.out.print("get to");
                        int temp = line;
                        result = edges[line][row];
                        for (int i = pathList.size() - 1; i >= 0; i--) {
                            Path path = pathList.get(i);
                            if (path.getEnd() == temp) {
                                if (path.getStart() == 0) {
                                    return result * path.getValue();
                                } else {
                                    temp = path.getStart();
                                    result *= path.getValue();
                                }
                            }
                        }
                    }
                    isVisited[row] = true;
                    queue.addLast(row);
                    pathList.add(new Path(line, row, edges[line][row]));

                }
                row = getNextNeighbor(line, row);
            }
        }
//        visitedStatus(to);

        return result;
    }

//    private void visitedStatus(int to) {
//        for (int i = 0; i < vertexList.size(); i++) {
//            if (!isVisited[i]) {
//                bfs(isVisited, i, to);
//            }
//        }
//    }

    public double bfs(String from, String to) {
        int indexF = vertexList.indexOf(from);
        int indexT = vertexList.indexOf(to);
        if (edges[indexF][indexT] != 0) {
            return edges[indexF][indexT];
        } else {
            return bfs(isVisited, indexF, indexT);
        }
    }

    public static void main(String[] args) {
        final Map<String, Double> marketData = new HashMap<String, Double>() {{
            this.put("BTC_USDT", 1000.0);
            this.put("ETH_USDT", 200.0);
            this.put("ABC_USDT", 2.0);
            this.put("DEF_ABC", 7.0);
            this.put("CNY_USDT", 0.14);
            // 孤岛币种
            this.put("GBP_SGD", 1.7);
        }};
        Graph graph = new Graph();
        for (String testInput : marketData.keySet()) {
            String from = testInput.split("_")[0];
            String to = testInput.split("_")[1];
            Double expected = marketData.get(testInput);

            if (!graph.vertexList.contains(from))
                graph.addVertex(from);
            if (!graph.vertexList.contains(to))
                graph.addVertex(to);
            graph.addEdges(graph.vertexList.indexOf(from), graph.vertexList.indexOf(to), expected);
        }

        for (Object str : graph.vertexList) {
            System.out.println(str.toString());
        }

        for (int i = 0; i < graph.edges.length; i++) {
            for (int j = 0; j < graph.edges[i].length; j++) {
                System.out.print(graph.edges[i][j] + " ");
            }
            System.out.println();
        }
        double result = graph.bfs("BTC", "GBP");
        System.out.println("---------  "+String.valueOf(result));
    }


}
