package latenciaredes.Model;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private int numero_enlaces;

    //Para no trabajar con una matriz de adyacencias, trabajamos con
    //un arreglo de ArrayList
    private ArrayList<Link>[] adjacencyList;

    public Graph(int vertices) {
        this.numero_enlaces = vertices;
        initAdjList();
    }

    private void initAdjList() {
        adjacencyList = new ArrayList[numero_enlaces];

        for (int i = 0; i < numero_enlaces; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public void addLink(Link link) {
        if (link.getSourceNode().getNumber() >= 0 && link.getSourceNode().getNumber() <= numero_enlaces - 1) {
            adjacencyList[link.getSourceNode().getNumber()].add(link);
        } else {
            System.out.println("No se puede agregar el nodo " + link + ": Fuera de rango");
        }
    }
    
    public void addLinkList(List<Link> linkList){
        for (int i = 0; i <= linkList.size() - 1; i++) {
            addLink(linkList.get(i));
        }
    }

    public List<Way> getAllWays(Node source, Node destination) {
        boolean[] isVisited = new boolean[numero_enlaces];

        ArrayList<Link> way = new ArrayList();
        List<Way> listWays = new ArrayList<>();

        getAllWaysUtil(source, destination, isVisited, way, listWays);

        return listWays;
    }

    private void getAllWaysUtil(Node source, Node destiny, boolean[] isVisited, List<Link> way, List<Way> listWays) {
        try {
            isVisited[source.getNumber()] = true;

            if (source.getNumber() == destiny.getNumber()) {
                Way n = new Way(
                        ((List<Link>) ((ArrayList) way).clone()),
                        0.0
                );

                listWays.add(n);
                isVisited[source.getNumber()] = false;
                return;
            }

            for (Link i : adjacencyList[source.getNumber()]) {
                if (!isVisited[i.getDestinyNode().getNumber()]) {
                    way.add(i);
                    getAllWaysUtil(i.getDestinyNode(), destiny, isVisited, way, listWays);
                    way.remove(i);
                }
            }

            isVisited[source.getNumber()] = false;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("error: Valores fuera de rango");
        }
    }
}
