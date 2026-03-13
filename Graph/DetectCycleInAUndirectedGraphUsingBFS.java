import java.util.*;
class Pair {
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class DetectCycleInAUndirectedGraphUsingBFS {

    public static boolean bfs(int src, int V, List<List<Integer>> adj, boolean visited[]){
        visited[src] = true;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src,-1));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int u = p.first;
            int parent = p.second;
            for(int v : adj.get(u)){
                if(!visited[v]){
                    visited[v] = true;  
                    q.add(new Pair(v,u));
                }
                else if(v!=parent) return true;
            }
        }
        return false;
    }

    public static boolean hasCycle(int V, int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(bfs(i,V,adj,visited)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {1, 3}, {3, 4}};
        System.out.println(hasCycle(V, edges)); // Output: true
    }
}