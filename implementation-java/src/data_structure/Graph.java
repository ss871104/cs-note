package data_structure;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    // undirected graph
    public boolean removeVertex(String vertex) {
        if (adjList.get(vertex) == null)
            return false;

        for (String otherVertex : adjList.get(vertex)) {
            adjList.get(otherVertex).remove(vertex);
        }

        adjList.remove(vertex);
        return true;
    }

    public void displayGraph() {
        System.out.println(adjList);
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.displayGraph();

        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("A", "C");

        graph.displayGraph();

        graph.removeEdge("A", "B");

        graph.displayGraph();

        Graph graph2 = new Graph();

        graph2.addVertex("A");
        graph2.addVertex("B");
        graph2.addVertex("C");
        graph2.addVertex("D");

        graph2.addEdge("A", "B");
        graph2.addEdge("A", "C");
        graph2.addEdge("A", "D");
        graph2.addEdge("B", "D");
        graph2.addEdge("C", "D");

        graph2.displayGraph();

        graph2.removeVertex("D");

        graph2.displayGraph();

    }
}
