package com.bhriguai.graphs.foundation;

import java.util.ArrayList;

public class EdgeListToAdjacencyMatrix {

    static ArrayList<ArrayList<Boolean>> convert_edge_list_to_adjacency_matrix(Integer n, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Boolean>> graph = new ArrayList<>();
        ArrayList<Boolean> adjLst = null;
        for (int i = 0; i < n; i++) {
            adjLst = new ArrayList<Boolean>();
            for (int j = 0; j < n; j++) {
                adjLst.add(false);
            }
            graph.add(adjLst);
        }

        for (ArrayList<Integer> edge: edges) {
            graph.get(edge.get(0)).set(edge.get(1), true);
            graph.get(edge.get(1)).set(edge.get(0), true);
        }

        return graph;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edgesList = new ArrayList<>();
        ArrayList<Integer> edges = new ArrayList<>();
        edges.add(0);edges.add(1);
        edgesList.add(edges);

        edges = new ArrayList<>();
        edges.add(1);edges.add(4);
        edgesList.add(edges);

        edges = new ArrayList<>();
        edges.add(1);edges.add(2);
        edgesList.add(edges);

        edges = new ArrayList<>();
        edges.add(1);edges.add(3);
        edgesList.add(edges);

        edges = new ArrayList<>();
        edges.add(3);edges.add(4);
        edgesList.add(edges);

        convert_edge_list_to_adjacency_matrix(5, edgesList);

        if (true)
            return;
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
