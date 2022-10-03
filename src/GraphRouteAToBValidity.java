import java.util.*;

public class GraphRouteAToBValidity {
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination)
            return true;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        visited.add(source);
        queue.add(source);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph.get(curr)) {
                if (next == destination)
                    return true;

                if (visited.contains(next))
                    continue;

                visited.add(next);
                queue.add(next);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] path = new int[][]{{0, 1}, {0, 2}};
        System.out.println(validPath(3, path, 0, 2));
    }
}
