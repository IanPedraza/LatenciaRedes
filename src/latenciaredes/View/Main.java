package latenciaredes.View;

import java.util.List;
import latenciaredes.Model.Graph;
import latenciaredes.Model.Link;
import latenciaredes.Model.Node;
import latenciaredes.Model.Way;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(6);

        int[] arregloOrigen = {0, 1, 1, 2, 3, 3, 4, 4};
        int[] arregloDestino = {1, 4, 2, 3, 4, 5, 3, 5};        
        
        for (int i = 0; i <= 7; i++) {
            Link link = new Link();
            link.setSourceNode(new Node(arregloOrigen[i], 0.0));
            link.setDestinyNode(new Node(arregloDestino[i], 0.0));
            
            System.out.println("Se agregó " + arregloOrigen[i] + "->" + arregloDestino[i] );
            
            graph.addLink(link);
        }

        /*
         graph.addEdge(0, 1);
         graph.addEdge(1, 4);
         graph.addEdge(1, 2);
         graph.addEdge(2, 3);
         graph.addEdge(3, 4);
         graph.addEdge(3, 5);
         graph.addEdge(4, 3);
         graph.addEdge(4, 5);
         */
        
        int s = 0;
        int d = 5;
        
        Node sourceNode = new Node(0, 0.0);
        Node destinyNode = new Node(5, 0.0);

        System.out.println("Las rutas de " + s + " a " + d);
        List<Way> caminos = graph.getAllWays(sourceNode, destinyNode);
        
        System.out.println("Size: " + caminos.size());
        
        for(int i = 0; i < caminos.size(); i++){
            
            for(int j = 0; j < caminos.get(i).getLinkList().size(); j++){
                System.out.print(caminos.get(i).getLinkList().get(j).getSourceNode().getNumber() + " -> ");
            }
           
            System.out.println("");
        }
        
    }

}
