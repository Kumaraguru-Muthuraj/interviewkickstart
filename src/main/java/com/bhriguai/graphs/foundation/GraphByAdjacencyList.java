package com.bhriguai.graphs.foundation;

import java.util.LinkedHashSet;
import java.util.Set;

public class GraphByAdjacencyList {
    public GraphByAdjacencyList(int V) {
        graph = new Set[V];
        size = V;
        for(int i = 0; i < size; i++) {
            graph[i] = new LinkedHashSet<>();
        }
    }

    public void addEdge(int i, int j) {
        graph[i].add(j);
        graph[j].add(i);
    }

    public void printGraph() {
        int i = 0;
        for (Set<Integer> list : graph) {
            System.out.print(i++ + " - ");
            for (Integer v : list) {
                System.out.print(v + ", ");
            }
            System.out.println();
        }
    }
    private Set<Integer>[] graph;
    private int size;
}
