package structures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import structures.nodes.Node;

public class Graph<T> {

    private Map<Node<T>, List<Node<T>>> mapa;

    public Graph(){
        this.mapa = new HashMap<Node<T>, List<Node<T>>>();
    }

    public void addNode(Node<T> node){
        //agrega el nodo y un espacio de memoria para sus conexiones
        mapa.putIfAbsent(node, new ArrayList<>());
        
    }
    
    public void addEdge(Node<T> n1, Node<T> n2){
        addNode(n1);
        addNode(n2);
        mapa.get(n1).add(n2);
        mapa.get(n2).add(n1);

    }

    public void printGraph(){
        for (Map.Entry<Node<T>, List<Node<T>>> entry : mapa.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Node<T> neighbor : entry.getValue()) {
                System.out.println(neighbor);
            }
            System.out.println();
        }

    }

    public Node<String>[] getNeighbors(Node<String> nA) {
        return mapa.get(nA).toArray(new Node[0]);
            
    }

   
}
