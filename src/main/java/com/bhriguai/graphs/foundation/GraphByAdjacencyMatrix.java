package com.bhriguai.graphs.foundation;


public class GraphByAdjacencyMatrix {
    public GraphByAdjacencyMatrix(int V) {
        graph = new int[V][V];
    }

    public void addEdge(int i, int j) {
        graph[i][j] = 1;
        graph[j][i] = 1;
    }

    public void printGraph() {
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " - ");
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == 1) {
                    System.out.print(j + ", ");
                }
            }
            System.out.println();
        }

    }
    int[][] graph;
}
