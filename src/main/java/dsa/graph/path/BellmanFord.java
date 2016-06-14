package dsa.graph.path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFord {

    public Integer[][] singleSourceShortestPath(Integer[][] weight,
            int source) throws Exception {

        //auxiliary constants
        final int SIZE = weight.length;
        final int EVE = -1;//to indicate no predecessor
        final int INFINITY = Integer.MAX_VALUE;

        //declare and initialize pred to EVE and minDist to INFINITY
        Integer[] pred = new Integer[SIZE];
        Integer[] minDist = new Integer[SIZE];
        Arrays.fill(pred, EVE);
        Arrays.fill(minDist, INFINITY);

        //set minDist[source] = 0 because source is 0 distance from itself.
        minDist[source] = 0;

        //relax the edge set V-1 times to find all shortest paths
        for (int i = 1; i < minDist.length - 1; i++) {
            for (int v = 0; v < SIZE; v++) {
                for (int x : adjacency(weight, v)) {
                    if (minDist[x] > minDist[v] + weight[v][x]) {
                        minDist[x] = minDist[v] + weight[v][x];
                        pred[x] = v;
                    }
                }
            }
        }

        //detect cycles if any
        for (int v = 0; v < SIZE; v++) {
            for (int x : adjacency(weight, v)) {
                if (minDist[x] > minDist[v] + weight[v][x]) {
                    throw new Exception("Negative cycle found");
                }
            }
        }

        Integer[][] result = {pred, minDist};
        return result;
    }

    /**
     * ****************************************************************
     * Retrieve all the neighbors of vertex v.
     * ***************************************************************
     */
    private List<Integer> adjacency(Integer[][] G, int v) {
        List<Integer> result = new ArrayList<>();
        for (int x = 0; x < G.length; x++) {
            if (G[v][x] != null) {
                result.add(x);
            }
        }
        return result;
    }

}