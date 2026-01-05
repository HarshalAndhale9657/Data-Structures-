import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;



public class Classroom{

    static class Heap{
        ArrayList<Integer> arr =  new ArrayList<>();

        public void add(int data){
            // add at last index
            arr.add(data);
            int x = arr.size()-1; // x is child index
            int par = (x-1)/2; // parent index

            while(arr.get(x) < arr.get(par)){ //O(logn)
                int temp = arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);
            }
        } 

        public int peek(){
            return arr.get(0);
        }
    }

    static class Student implements Comparable<Student> {//overriding
        String name;
        int rank;

        public Student(String name,int rank){
            this.name = name;
            this.rank=rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student>pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(new Student("A", 4));
        pq.add(new Student("B", 5));
        pq.add(new Student("C", 6));
        pq.add(new Student("D", 7));
        pq.add(new Student("E", 8));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name+" -> " +pq.peek().rank);
            pq.remove();

        }
    }
}