package algorithms;

import java.util.*;

class Graph {
    private int numVertices; // Number of vertices
    private LinkedList<Integer> adj[]; // Adjacency list representation

    // Constructor
    Graph(int numVertices) {
        this.numVertices = numVertices;
        adj = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; ++i)
            adj[i] = new LinkedList<>();
    }

    // Add an edge to the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Recursive function for DFS traversal
    void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v) {
        // Mark all the vertices as not visited (set as false by default)
        boolean visited[] = new boolean[numVertices];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Depth First Traversal starting from vertex 2:");

        g.DFS(2);
    }
}
