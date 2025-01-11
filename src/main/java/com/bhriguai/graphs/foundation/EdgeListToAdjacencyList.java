package com.bhriguai.graphs.foundation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


class GraphByAdjacencyList2 {
    public GraphByAdjacencyList2(int V) {
        graph = new ArrayList<>();
        size = V;
        for(int i = 0; i < size; i++) {
            graph.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int i, int j) {
        graph.get(i).add(j);
        graph.get(j).add(i);
    }

    public void printGraph() {
        int i = 0;
        for (List<Integer> list : graph) {
            System.out.print(i++ + " - ");
            for (Integer v : list) {
                System.out.print(v + ", ");
            }
            System.out.println();
        }
    }
    private ArrayList<ArrayList<Integer>> graph;
    private int size;
}

public class EdgeListToAdjacencyList {
    public EdgeListToAdjacencyList() {

    }

    public static ArrayList<ArrayList<Integer>> convert_edge_list_to_adjacency_list(Integer n, ArrayList<ArrayList<Integer>> edges) {
        GraphByAdjacencyList2 graphByAdjacencyList = new GraphByAdjacencyList2(n);
        for (ArrayList<Integer> edge : edges) {
            graphByAdjacencyList.addEdge(edge.get(0), edge.get(1));
        }

        graphByAdjacencyList.printGraph();

        return null;
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

        if (true) return;
        System.out.println("\n\n");

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

        convert_edge_list_to_adjacency_list(5, edgesList);


    }
}
