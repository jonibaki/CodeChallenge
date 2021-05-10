package Tibra.com;

import java.util.List;

public class ExerciseTwo {
    /*
     * Complete the 'maximum_path' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY node_values as parameter.
     */

    public static int maximum_path(List<Integer> node_values) {
        //create a LinkedList from a given list
        //Todo: create a new class of LinkList with node as header, leftNode, rightNode;
        LinkedList searchTree = new LinkedList();

        for(int i=0; i <node_values.size(); i++){
            searchTree.insert(node_values.get(i));
        }

        // Loop through each branch until there is node or null
        // calculate each node and store the value in a list
        //return the max value
        return 0;
    }

}
class LinkedList{
    private Node<Integer> root;
    LinkedList(){
        root = null;
    }
    public boolean insert(Integer data){
        Node<Integer> parent = root, child = root;
        boolean goneLeft = false;

        while(child !=null && data.compareTo(child.data) !=0){
            parent = child;
            if(data.compareTo(child.data)<0){
                child = child.left;
                goneLeft =true;
            }else {
                child = child.right;
                goneLeft = false;
            }
        }
        if(child!= null){
            return  false;
        }else{
            Node<Integer> leafNode = new Node<>(data);
            if(parent == null){
                root = leafNode;
            }else if(goneLeft){
                parent.left = leafNode;
            }else{
                parent.right = leafNode;
            }
            return true;
        }

    }
    public int preOrderSearch(Node node){
        int total =0;
        if(node == null){
            return 0;
        }
        total +=preOrderSearch(node.left);
        total +=preOrderSearch(node.right);

        return total;
    }
}
class Node<Integer>{
    int data;
    Node<Integer> left, right;
    Node(int num){
        data = num;
        left= right= null;
    }
}
