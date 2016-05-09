package dsa.graph;

import java.util.*;

/**
 *
 * Data structure used to represent a graph
 */
public class GraphMatrix {

    int[][] adjMatrix;
    int rootNode = 0;
    int NNodes;

    boolean[] visited;

    /**
     * Construct a graph of N nodes
     *
     * @param N
     */
    public GraphMatrix(int N) {
        NNodes = N;
        adjMatrix = new int[N][N];
        visited = new boolean[N];
    }

    public GraphMatrix(int[][] mat) {
        int i, j;

        NNodes = mat.length;

        adjMatrix = new int[NNodes][NNodes];
        visited = new boolean[NNodes];

        for (i = 0; i < NNodes; i++) {
            for (j = 0; j < NNodes; j++) {
                adjMatrix[i][j] = mat[i][j];
            }
        }
    }

    /**
     * BFS uses Queue data structure
     *
     * @return
     */
    public List<Integer> bfs() {

        List<Integer> walk = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        q.add(rootNode);
        visited[rootNode] = true;

        walk.add(rootNode);

        while (!q.isEmpty()) {
            int n, child;
            n = q.peek();

            child = getUnvisitedChildNode(n);

            if (child != -1) {
                visited[child] = true;

                walk.add(child);

                q.add(child);
            } else {
                q.remove();
            }
        }

        clearVisited();      //Clear visited property of nodes

        return walk;
    }

    /**
     * DFS uses Stack data structure
     *
     * @return
     */
    public List<Integer> dfs() {

        List<Integer> walk = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        s.push(rootNode);
        visited[rootNode] = true;

        walk.add(rootNode);

        while (!s.isEmpty()) {
            int n, child;

            n = s.peek();

            child = getUnvisitedChildNode(n);

            if (child != -1) {
                visited[child] = true;

                walk.add(child);

                s.push(child);
            } else {
                s.pop();
            }
        }

        clearVisited();      //Clear visited property of nodes

        return walk;
    }

    public int getUnvisitedChildNode(int n) {
        for (int j = 0; j < NNodes; j++) {
            if (adjMatrix[n][j] > 0) {
                if (!visited[j]) {
                    return j;
                }
            }
        }

        return -1;
    }

    public void clearVisited() {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }

}
