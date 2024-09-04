package BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {

    }

    public static void BFS(List<List<Integer>> graph, int src){
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        visited[src] = true;

        while(q.size()>0){
            int removed = q.remove();
//            visited[removed] = true;
            System.out.println("Node: " + removed);

            List<Integer> nbrs = graph.get(removed);

            for(int nbr : nbrs){
                if(visited[nbr] == false){
                    q.add(nbr);
                    visited[nbr] = true;
                }
            }
        }
    }

}
