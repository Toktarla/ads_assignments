import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyGraph<Hey> {

    private boolean undirected;
    private Map<Hey, List<Hey>> map = new HashMap<>();

    public MyGraph () {
        this.undirected = true;
    }
    public MyGraph (boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex (Hey vertex) {
        map.put(vertex,new LinkedList<>());
    }

    public boolean hasVertex (Hey vertex) {
        return map.containsKey(vertex);
    }

    public int getVerteciesCount () {
        return map.size();
    }


    public int getEdgesCount () {
        int count = 0;

        for (Hey v : map.keySet()) {
            count += adjacencyList(v).size();
        }

        if (undirected) {
            count /= 2;
        }

        return count;

    }

    public void addEdge (Hey source, Hey dest) {

        if (!hasVertex(source)) addVertex(source);

        if (!hasVertex(dest)) addVertex(dest);

        if (hasEdge(source,dest) || source.equals(dest)) return;

        map.get(source).add(dest);

        if (undirected) {
            map.get(dest).add(source);
        }

    }

    private boolean hasEdge (Hey source, Hey dest) {
        if (!hasVertex(source)) return false;
        return map.get(source).contains(dest);
    }

    public List<Hey> adjacencyList (Hey vertex) {
        if (!hasVertex(vertex)) return null;
        return map.get(vertex);
    }




}
