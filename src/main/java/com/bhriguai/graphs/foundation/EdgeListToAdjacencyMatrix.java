package com.bhriguai.graphs.foundation;

public class EdgeListToAdjacencyMatrix {
    public static void main(String[] args) {
        GraphByAdjacencyMatrix g = new GraphByAdjacencyMatrix(10);

        g.addEdge(0,1);
        g.addEdge(0,6);
        g.addEdge(0,8);

        g.addEdge(1, 4);
        g.addEdge(1, 6);
        g.addEdge(1, 9);

        g.addEdge(2, 4);
        g.addEdge(2, 6);

        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(3, 8);

        g.addEdge(4, 5);
        g.addEdge(4, 9);

        g.addEdge(7, 8);
        g.addEdge(7, 9);

        g.printGraph();
    }
}
