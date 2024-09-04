package DFS;

import java.util.List;

public class DFS {
    public static void main(String[] args) {

    }

    public static void DFS(List<List<Integer>> graph, int src, boolean[] visited){

        visited[src] = true;

        System.out.println("Node: " + src);

        List<Integer> nbrs = graph.get(src);

        for(int nbr : nbrs){
            if(visited[nbr]==false){
                DFS(graph, nbr, visited);
            }
        }
    }

}
