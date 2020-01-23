package latenciaredes.View;

import latenciaredes.Model.Graph;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(6); 
        graph.addEdge(0, 1);
        graph.addEdge(1, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
      
        int s = 0; 
        int d = 5; 
      
        System.out.println("Las rutas de " + s + " a " + d); 
        graph.printAllPaths(s, d); 
    }
    
}
