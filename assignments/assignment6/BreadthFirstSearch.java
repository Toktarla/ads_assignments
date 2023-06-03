import java.util.*;

public class BreadthFirstSearch<Hey> extends Search<Hey> {

    public BreadthFirstSearch(MyGraph<Hey> graph, Hey source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(MyGraph<Hey> graph, Hey current) {
        marked.add(current);
        Queue<Hey> queue = new LinkedList<>();
        queue.add(current);
        while (!queue.isEmpty()) {
            Hey v = queue.remove();
            for (Hey vertex : graph.adjacencyList(v)) {
                if (!marked.contains(vertex)) {
                    marked.add(vertex);
                    edgeTo.put(vertex, v);
                    queue.add(vertex);
                }
            }
        }
    }
}
