package structures.trees;

import models.Person;
import structures.nodes.Node;

public class Tree<T extends Comparable<T>> {

    private Node<T> root;

    public Tree(){
        this.root = null;
    }

    //metodo para insertar 

    public void insert(T value){
        root = insertRecursive(root, value);

    }

    private Node<T> insertRecursive(Node<T> current, T value){
        if (current == null) {
            return new Node<T>(value);   
        }

        
        if (value.compareTo(current.getValue()) < 0) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (value.compareTo(current.getValue()) > 0) {
            current.setRight(insertRecursive(current.getRight(), value));
        }
        return current;
    }

    //metodo inOrder

     public void inOrder(){
        inOrderRecursive(root);
        System.out.println();
    }
    private void inOrderRecursive(Node<T> node){

        if (node != null) {
            inOrderRecursive(node.getLeft());
            System.out.println(node.getValue() + " ");
            inOrderRecursive(node.getRight());
        }
    }

    public T searchByAge(int age) {
        return searchByAgeRecursive(root, age);
    }
    
    private T searchByAgeRecursive(Node<T> current, int age) {
        if (current == null) 
            return null;

        Person p = (Person) current.getValue(); 

        if (p.getAge() == age) {
            return current.getValue();
        } else if (age < p.getAge()) {   
            return searchByAgeRecursive(current.getLeft(), age);
        } else {
            return searchByAgeRecursive(current.getRight(), age);
        }
    }
    
    public T search(T key) {
        return searchByAgeRecursive(root, key);
    }

    private T searchByAgeRecursive(Node<T> current, T key) {
        if (current == null) 
            return null;
        if (key.compareTo(current.getValue()) == 0) {
            return current.getValue();
        } else if (key.compareTo(current.getValue()) < 0) {
            return searchByAgeRecursive(current.getLeft(), key);
        } else {
            return searchByAgeRecursive(current.getRight(), key);
        }
    }
}
