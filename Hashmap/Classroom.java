import java.util.*;

public class Classroom{


    public static void main(String[] args) {
        // create hashmap
        HashMap<String,Integer> hm = new HashMap<>();

        // Insert O(1)
        hm.put("India",100);
        hm.put("US",150);
        hm.put("China",160);
        System.out.println(hm);

        // Get - O(1)
        int population = hm.get("India");
        System.out.println(population);
        System.out.println(hm.containsKey("India"));

        //Remove - O(1)
        // System.out.println(hm.remove("China"));
        // System.out.println(hm);

        //Size
        System.out.println(hm.size());

        //is Empty
        System.out.println(hm.isEmpty());

        // Iteration in hashmap using set
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for(String k : keys){
            System.out.println("key = "+k+", value = " +hm.get(k));
        }

               int arr[] = {15,-2,2,-8,1,7,10,23};

        HashMap<Integer ,Integer>map = new HashMap<>();
        //(sum,idx)
        int sum = 0;
        int len = 0;

        for(int j=0;j<arr.length; j++){
            sum += arr[j];
            if(map.containsKey(sum)){
                len = Math.max(len,j-map.get(sum));
            }else{
                map.put(sum,j);
            }
        }
        System.out.println("largest subarr with sum 0 = "+len);
    }
}