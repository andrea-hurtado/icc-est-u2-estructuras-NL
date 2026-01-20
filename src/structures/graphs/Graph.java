package structures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import structures.nodes.Node;

public class Graph<T> {

    private Map<Node<T>, List<Node<T>>> mapa;

    public Graph(){
        this.mapa = new HashMap<Node<T>, List<Node<T>>>();
    }

    public void addNode(Node<T> node){
        //agrega el nodo y un espacio de memoria para sus conexiones
        mapa.putIfAbsent(node, new ArrayList<>());
        //retorna un valor solo si la clave no existe     
    }
    
    public void addEdge(Node<T> n1, Node<T> n2){
        addNode(n1);
        addNode(n2);
        mapa.get(n1).add(n2);
        mapa.get(n2).add(n1);
    }

    public void addConocido(Node<T> n1, Node<T> n2){
        addNode(n1);
        addNode(n2);
        mapa.get(n1).add(n2);
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

    public List<Node<T>> getNeighbors(Node<T> n) {
        return mapa.getOrDefault(n, List.of());
            
    }

    //bfs busca por anchura y luego va al siguiente nodo
    public void bfs(Node<T> start){
        //set permite que no haya duplicados
        Set<Node<T>> visitados = new LinkedHashSet<>();
        Queue<Node<T>> queue = new LinkedList<>();
        visitados.add(start);
        queue.add(start);

        while (!queue.isEmpty()) { //para romper el bucle, vacia la cola
            Node<T> current = queue.poll();
            System.out.print(current.getValue() + " ");

            for (Node<T> conocido : getNeighbors(current)) {
                if (!visitados.contains(conocido)) {
                    visitados.add(conocido);
                    queue.add(conocido);
                }
            }
        }      
    } 
    
    public void dfs(Node<T> start){
        Set<Node<T>> visitados = new LinkedHashSet<>();
        dfsRecursividad(start, visitados);
    }

    private void dfsRecursividad(Node<T> current, Set<Node<T>> visitados) {
       visitados.add(current);
       System.out.println(current.getValue() + " ");
       for (Node<T> conocido : getNeighbors(current)) {
          if (!visitados.contains(conocido)) {
              dfsRecursividad(conocido, visitados);  
            
          } 
       }
    }
}
