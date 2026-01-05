import java.util.*;
public class HashMapCode {
    static class HashMap<K,V>{ // generic
       private class Node{
        K key;
        V value;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private int size; //n
    private LinkedList <Node> buckets[];  //N = bucketx.length

    @SuppressWarnings("unchecked")
    public HashMap(){
        this.size=4;
        this.buckets = new LinkedList[4];
        for(int i = 0;i<4;i++){
            this.buckets[i]=  new LinkedList<>();
        }
    }

    private int hashFunction(K key){
        int hc = key.hashCode();
        return Math.abs(hc) % size;
    }
    private int SearchInLL(K key,int bi){
        LinkedList<Node>ll = buckets[bi];
        int di = 0;
        for(int i =0;i<ll.size();i++){
            Node node = ll.get(i);
            if(node.key == key){
                return di;
            }
            di++;
        }
        return -1;
    }
    public void put(K key, V value){
        int bi = hashFunction(key);
        int di = SearchInLL(key,bi);
    }


    }
    public static void main(String[] args) {
        //   HashSet<Integer> set = new HashSet<>();
        //   set.add(1);
        //   set.add(2);
        //   set.add(3);
        //   set.add(4);
        //   set.add(5);

        //   Iterator it = set.iterator();
        //   while (it.hasNext()) {
        //     System.out.println(it.next());
            
        //   }

        //   for(int i:set){
        //     System.out.println(i);
        //   }

 


    }
    
}
