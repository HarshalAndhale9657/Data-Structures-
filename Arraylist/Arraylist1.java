import java.util.ArrayList;

public class Arraylist1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Boolean> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();

        // add a element in list
        list.add(1); // Time complexity of O(1) ----constant time complaxity
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list);

        list.add(2, 55);
        System.out.println(list);

        // // get a element on Nth index
        // int element = list.get(2); // constant time complaxity
        // System.out.println(element);

        // // Delete an element
        // list.remove(2); // linear time complexity
        // System.out.println(list);

        // // set element at index
        // list.set(2, 10); // linear time complexity
        // System.out.println(list);

        // contains element
        // System.out.println(list.contains(1)); // linear time complexity
        // System.out.println(list.contains(8));

    }
}