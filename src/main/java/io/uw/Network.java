package io.uw;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Network {

    private final int size;
    private HashMap<Integer, Node> nodes;

    public Network(int size){
        if(size <= 0 ) throw new IllegalArgumentException("Size must be positive integer");
        this.size = size;
        this.nodes = new HashMap<>(size);
        for (int i = 1; i <= size; i++){
            Node node = new Node(i);
            nodes.put(i, node);
        }
    }

    public void connect(int source, int dest){
        if(( source <= 0 || source > size) || ( dest <= 0 || dest > size))
            throw  new IllegalArgumentException("Input must be greater than 0 and less or equal to "+size);
        addConnection(source, dest);
    }

    public boolean query(int source, int dest){
        if(( source <= 0 || source > size) || ( dest <= 0 || dest > size))
            throw  new IllegalArgumentException("Input must be greater than 0 and less or equal to "+size);
        return hasConnection(getNode(source), getNode(dest));
    }


    private class Node {
        private int id;
        LinkedList<Node> connections = new LinkedList<>();

        private Node(int id){
            this.id = id;
        }
    }

    private Node getNode(int id){
       return nodes.get(id);
    }

    private void addConnection(int source, int dest){
        Node s = getNode(source);
        Node d = getNode(dest);
        s.connections.add(d);
        d.connections.add(s);
    }

    private boolean hasConnection(Node source, Node dest){
        LinkedList<Node> next = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        next.add(source);
        while (!next.isEmpty()){
            Node node = next.remove();
            if(node.id == dest.id){
                return true;
            }

            if(visited.contains(node.id)){
                continue;
            }
            visited.add(node.id);

            for(Node conn : node.connections){
                next.add(conn);
            }
        }
        return false;
    }
}
