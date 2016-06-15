package dsa.ai.graph.path.astar;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Helper class containing pathfinding algorithms.
 *
 */
public class AStar {

    /**
     * A Star pathfinding. Note that the heuristic has to be monotonic:      
     * {@code h(x) <= d(x, y) + h(y)}.
     *
     * @param <T>
     * @param start Starting node
     * @param goal Goal node
     * @return Shortest path from start to goal, or null if none found
     */
    public static <T extends Node<T>> List<T> doAStar(T start, T goal) {
        Set<T> closed = new HashSet<>();
        Map<T, T> fromMap = new HashMap<>();
        List<T> route = new LinkedList<>();
        Map<T, Double> gScore = new HashMap<>();
        final Map<T, Double> fScore = new HashMap<>();
        PriorityQueue<T> open = new PriorityQueue<>(11, new Comparator<T>() {

            @Override
            public int compare(T nodeA, T nodeB) {
                return Double.compare(fScore.get(nodeA), fScore.get(nodeB));
            }
        });

        gScore.put(start, 0.0);
        fScore.put(start, start.getHeuristic(goal));
        open.offer(start);

        while (!open.isEmpty()) {
            T current = open.poll();
            if (current.equals(goal)) {
                while (current != null) {
                    route.add(0, current);
                    current = fromMap.get(current);
                }

                return route;
            }

            closed.add(current);

            for (T neighbour : current.getNeighbours()) {
                if (closed.contains(neighbour)) {
                    continue;
                }

                double tentG = gScore.get(current)
                        + current.getTraversalCost(neighbour);

                boolean contains = open.contains(neighbour);
                if (!contains || tentG < gScore.get(neighbour)) {
                    gScore.put(neighbour, tentG);
                    fScore.put(neighbour, tentG + neighbour.getHeuristic(goal));

                    if (contains) {
                        open.remove(neighbour);
                    }

                    open.offer(neighbour);
                    fromMap.put(neighbour, current);
                }
            }
        }

        return null;
    }

}
