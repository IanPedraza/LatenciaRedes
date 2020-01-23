package latenciaredes.Model;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private int numero_enlaces;

    //Para no trabajar con una matriz de adyacencias, trabajamos con
    //un arreglo de ArrayList
    private ArrayList<Integer>[] adjacencyList;

    public Graph(int vertices) {
        this.numero_enlaces = vertices;
        initAdjList();
    }

    private void initAdjList() {
        adjacencyList = new ArrayList[numero_enlaces];

        for (int i = 0; i < numero_enlaces; i++) 
            adjacencyList[i] = new ArrayList<>();        
    }

    public void addEdge(int sourceNode, int destinationNode) {
        if (sourceNode >= 0 && sourceNode <= numero_enlaces - 1) {
            adjacencyList[sourceNode].add(destinationNode);
        } else {
            System.out.println("No se puede agregar el nodo " + sourceNode + ": Fuera de rango");
        }
    }

    public void printAllPaths(int source, int destination) {
        boolean[] isVisited = new boolean[numero_enlaces];
        ArrayList<Integer> pathList = new ArrayList<>();

        pathList.add(source);
        printAllPathsUtil(source, destination, isVisited, pathList);
    }

    private void printAllPathsUtil(Integer node, Integer destination, boolean[] isVisited, List<Integer> localPathList) {
        try {
            isVisited[node] = true;

            if (node.equals(destination)) {
                System.out.println(localPathList);
                isVisited[node] = false;
                return;
            }

            for (Integer i : adjacencyList[node]) {
                if (!isVisited[i]) {
                    localPathList.add(i);
                    printAllPathsUtil(i, destination, isVisited, localPathList);
                    localPathList.remove(i);
                }
            }

            isVisited[node] = false;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("error: Valores fuera de rango");
        }
    }
}
