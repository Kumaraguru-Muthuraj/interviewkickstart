package com.bhriguai.graphs.foundation;

public class EdgeListToAdjacencyList {
    public EdgeListToAdjacencyList() {

    }
    public static void main(String[] args) {
        GraphByAdjacencyList graphByAdjacencyList = new GraphByAdjacencyList(10);
        graphByAdjacencyList.addEdge(0,1);
        graphByAdjacencyList.addEdge(0,6);
        graphByAdjacencyList.addEdge(0,8);

        graphByAdjacencyList.addEdge(1, 4);
        graphByAdjacencyList.addEdge(1, 6);
        graphByAdjacencyList.addEdge(1, 9);

        graphByAdjacencyList.addEdge(2, 4);
        graphByAdjacencyList.addEdge(2, 6);

        graphByAdjacencyList.addEdge(3, 4);
        graphByAdjacencyList.addEdge(3, 5);
        graphByAdjacencyList.addEdge(3, 8);

        graphByAdjacencyList.addEdge(4, 5);
        graphByAdjacencyList.addEdge(4, 9);

        graphByAdjacencyList.addEdge(7, 8);
        graphByAdjacencyList.addEdge(7, 9);

        graphByAdjacencyList.printGraph();
    }
}
