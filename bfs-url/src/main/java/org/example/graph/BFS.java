package org.example.graph;

import java.util.*;

public class BFS {

    public static<T> Optional<Node<T>> search(T value, Node<T> start){
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(start);

        Node<T> currentNode;
        Set<Node<T>> closed = new HashSet<>();

        while(!queue.isEmpty()){ //1 - Verifico si puedo continuar
            currentNode = queue.remove();
            System.out.println("Visitando el nodo " + currentNode.getValue());
            //2 - Verifico si se encuentra en la meta
            if(currentNode.getValue().equals(value)){
                return Optional.of(currentNode);
            }else {
                closed.add(currentNode); //3 - Espacio explorado
                queue.addAll(currentNode.getNeighbors()); //4 - Función suscesora
                queue.removeAll(closed);
            }

        }
        return Optional.empty();
    }
}
