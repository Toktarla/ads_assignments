public class Main {
    public static void main(String[] args) {
        MyGraph<String> myGraph = new MyGraph<>();
        WeightedGraph<String> weightedGraph = new WeightedGraph<>();
        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.addVertex("D");
        myGraph.addVertex("E");

        myGraph.addEdge("A", "B");
        myGraph.addEdge("B", "C");
        myGraph.addEdge("C", "D");
        myGraph.addEdge("D", "E");
        myGraph.addEdge("E", "A");

        String source = "A";
        String target= "C";

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(myGraph, source);
        if (bfs.hasPathTo(target)) {
            Iterable<String> path = bfs.pathTo(target);
            System.out.print("Result : ");
            for (String v : path) {
                System.out.print(v + " ");
            }
            System.out.println();
        } else {
            System.out.println("No path");
        }

        weightedGraph.addEdge("Almaty", "Astana", 2.1);
        weightedGraph.addEdge("Almaty", "Shymkent", 7.2);
        weightedGraph.addEdge("Shymkent", "Astana", 3.9);
        weightedGraph.addEdge("Astana", "Kostanay", 3.5);
        weightedGraph.addEdge("Shymkent", "Kyzylorda", 5.4);
        String source2 = "Almaty";
        DijkstraSearch<String> dijkstraSearch = new DijkstraSearch<>(weightedGraph, source2);


        String destination = "Kyzylorda";
        if (dijkstraSearch.hasPathTo(destination)) {
            System.out.println("Shortest path from " + source2 + " to " + destination + ":");
            for (String vertex : dijkstraSearch.pathTo(destination)) {
                System.out.print(vertex + " ");
            }
            System.out.println();
            System.out.println("Total distance: " + dijkstraSearch.getShortestDistance(destination));
        } else {
            System.out.println("No path found from " + source2 + " to " + destination);
        }
    }
}
