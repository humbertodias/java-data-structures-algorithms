package dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private final List<Vertex> vertexes;
    private final List<Edge> edges;

    public Graph() {
        this.vertexes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public Graph(List<Vertex> vertexes, List<Edge> edges) {
        this.vertexes = vertexes;
        this.edges = edges;
    }

    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addVertex(Vertex v) {
        this.vertexes.add(v);
    }

    public void addEdge(Edge e) {
        this.edges.add(e);
    }

    private int[][] cleanMatrix() {
        int n = this.getVertexes().size();
        int mat[][] = new int[n][n];
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                mat[i][j] = 0;
            }
        }
        return mat;
    }

    public int[] V() {
        int[] vs = new int[vertexes.size()];

        for (int i = 0; i < vertexes.size(); i++) {
            vs[i] = Integer.parseInt(vertexes.get(i).getId());
        }

        return vs;
    }

    public int[][] adj() {
        int[][] mat = cleanMatrix();

        int source, dest;
        for (Edge edge : edges) {
            source = Integer.parseInt(edge.getSource().getId());
            dest = Integer.parseInt(edge.getDestination().getId());
            mat[source][dest] = edge.getWeight();
        }

        return mat;
    }

}
