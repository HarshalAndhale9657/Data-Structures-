import java.util.LinkedList;
import java.util.Queue;

public class bt {
    public class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left=null;
            this.right=null;

        }
    }
    Node root;

    public void add(int data){
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            
        }

    }



    public static void main(String[] args) {
        
    }


}
