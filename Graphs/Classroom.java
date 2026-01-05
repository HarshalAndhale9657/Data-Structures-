import java.util.*;

public class Classroom {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0-vertex
        graph[0].add(new Edge(0, 1, 5));
        // 1-vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        // 2-vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));
        // 3-vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));
        // 4-vertex
        graph[4].add(new Edge(4, 2, 2));
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfsUtil(graph, vis);
            }
        }
    }

    // bfs using array of arraylist
    public static void bfsUtil(ArrayList<Edge>[] graph, boolean vis[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0); // starting element

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {
                System.out.println(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            dfsUtil(graph, i, vis);
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
        // visit
        System.out.println(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    // bfs using Arraylist of Arraylist
    static ArrayList<Integer> bfs2(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int vis[] = new int[n];

        q.add(0);
        vis[0] = 1;

        while (!q.isEmpty()) {
            int curr = q.remove();
            ans.add(curr);

            for (int conn : adj.get(curr)) {
                if (vis[conn] == 0) {
                    vis[conn] = 1;
                    q.add(conn);
                }
            }
        }
        return ans;

    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) {
        if (src == dest)
            return true;
        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            // e.dest = neighbour
            if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
                return true;
            }
        }

        return false;
    }

    // cycle detection in undirected graph O(V+E)
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                    // cycle exist in one of the parts
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int par) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // case 3
            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr))
                    return true;
            }
            // case 1
            else if (vis[e.dest] && e.dest != par) {
                return true;
            }
            // case 2 -> do nothing continue

        }
        return false;
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int col[] = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1; // no color
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                q.add(i);
                col[i] = 0; // yellow
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j); // e.dest
                        if (col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if (col[e.dest] == col[curr]) {
                            return false; // not bipartite
                        }
                    }
                }
            }
        }
        return true;
    }

    //cycle in directed graph
    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) {
                return true;
            }
            if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }

        stack[curr] = false;
        return false;
    }

    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void topSort(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.println(s.pop() + " ");
        }
    }


    // topological sort using bfs

    public static void calcIndeg(ArrayList<Edge> graph[],int indeg[]){
        for(int i =0;i<graph.length;i++){
            int v = i;
            for(int j =0;j<graph[v].size();j++){
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }
    public static void topSortb(ArrayList<Edge>[]graph){
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i =0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }

        //bfs
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.println(curr+" ");

            for(int i =0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;

                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }

        }
        System.out.println();
    }


    //toposort kahns algo (Arraylist of arraylist as input)
    public ArrayList<Integer>  toposort(ArrayList<ArrayList<Integer>>adj){
        int n = adj.size();
        int indegree[] = new int[n];
        for(int curr = 0;curr<n;curr++){
            for(int conn: adj.get(curr)){
                indegree[conn]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while(q.isEmpty()==false){
            int curr = q.remove();
            ans.add(curr);
            for(int conn:adj.get(curr)){
                indegree[conn]--;
                if(indegree[conn]==0){
                    q.add(conn);
                }
            }
        }
        if(ans.size() != n){ // cycle detected no topological sorting possible
            return new ArrayList<>();
        }
        return ans;
    }


    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V]; // this is an array of arraylist
        // Important: This only creates the array, not the ArrayLists inside it.
        // null -> empty arraylist

        createGraph(graph);
        // bfs(graph);
        // dfs(graph,0,new boolean[graph.length]);

        // System.out.println(hasPath(graph, 1, 4, new boolean [V]));

        // // 2's neighbour
        // for(int i=0;i<graph[2].size();i++){
        // Edge e = graph[2].get(i); //src,dest,wt
        // System.out.println(e.dest);
        // }
        // System.out.println();
        // System.out.println(isBipartite(graph));

        // System.out.println(detectCycle(graph));;

        System.out.println(isCycle(graph));
       // topSort(graph);
        topSortb(graph);

    }
}