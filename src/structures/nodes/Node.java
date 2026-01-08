package structures.nodes;

import java.util.List;
import java.util.Map;

public class Node <T> {

    private T value;
    private Node<T> left;
    private Node<T> right;

    private Map<Node<T>, List<Node<T>>> mapa;
    
    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    
    }

    public T getValue(){
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    @Override
    public String toString(){
        return "N[" + value + "]";
    }
    
}
