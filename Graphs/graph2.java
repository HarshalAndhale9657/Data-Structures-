import java.util.*;

public class graph2 {

    static boolean cycleUsingBfs(int source, ArrayList<ArrayList<Integer>> adj, boolean isVisited[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        isVisited[source] = true;

        while(q.isEmpty()==false){
            int curr = q.remove();
            for(int conn : adj.get(curr)){
                if(isVisited[conn]==true){
                    // there is a cycle
                    return true;
                }else{
                    isVisited[conn] = true;
                    q.add(conn);
                }
            }

        }
        // no cycle
        return false;
    }


    static boolean detect(ArrayList<ArrayList<Integer>> adj, boolean isVisited[]){
        for(int i =0;i<adj.size();i++){
            if(isVisited[i]==false){
                boolean result = cycleUsingBfs(i, adj, isVisited);
                if(result == true){
                    return true;
                }
            }
        }

        return false;
    }




    public static void main(String[] args) {
        
    }
}
