package latenciaredes.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import latenciaredes.Interfaces.INetworkData;

public class NetworkData implements INetworkData {

    private Double packageSize;
    private Node sourceNode;
    private Node destinyNode;
    private Node[] nodeList;
    private List<Link> linksList;

    public NetworkData() {
        this.packageSize = 0.0;
        this.sourceNode = new Node();
        this.destinyNode = new Node();
        this.nodeList = new Node[0];
        this.linksList = new ArrayList();
    }

    public Double getPackageSize() {
        return packageSize;
    }

    public void setPackageSize(Double packageSize) {
        this.packageSize = packageSize;
    }

    public Node getSourceNode() {
        return sourceNode;
    }

    public void setSourceNode(Node sourceNode) {
        this.sourceNode = sourceNode;
    }

    public Node getDestinyNode() {
        return destinyNode;
    }

    public void setDestinyNode(Node destinyNode) {
        this.destinyNode = destinyNode;
    }

    public Node[] getNodeList() {
        return nodeList;
    }

    public void setNodeList(Node[] nodeList) {
        this.nodeList = nodeList;
    }

    public List<Link> getLinksList() {
        return linksList;
    }

    public void setLinksList(List<Link> linksList) {
        this.linksList = linksList;
    }

    @Override
    public void loadData(String path) {

        try {

            //Abrir el archivo
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            //Obtener los valores de nodos y enlaces
            String firstLine = scanner.nextLine();
            String[] decodificadorInicial = firstLine.split(",");

            int numeroNodos = Integer.parseInt(decodificadorInicial[0].trim());
            int numeroEnlaces = Integer.parseInt(decodificadorInicial[1].trim());

            //Obtener los nodos
            nodeList = new Node[numeroNodos];

            for (int i = 0; i < numeroNodos; i++) {
                String lineaNodo = scanner.nextLine();
                String[] decodificadorNodos = lineaNodo.split(",");

                int numeroNodo = Integer.parseInt(decodificadorNodos[0].trim());
                Double queuingDelay = Double.parseDouble(decodificadorNodos[1].trim());

                if (this.nodeList != null) {
                    this.nodeList[numeroNodo] = new Node(numeroNodo, queuingDelay);
                }
            }

            //Obtener Enlaces
            for (int i = 0; i < numeroEnlaces; i++) {
                String lineaEnlace = scanner.nextLine();
                String[] decodificadorEnlaces = lineaEnlace.split(",");

                Node sourceNode = nodeList[Integer.parseInt(decodificadorEnlaces[0].trim())];
                Node destinyNode = nodeList[Integer.parseInt(decodificadorEnlaces[1].trim())];
                Double speed = Double.parseDouble(decodificadorEnlaces[2].trim());
                Double distance = Double.parseDouble(decodificadorEnlaces[3].trim());
                Double controlData = Double.parseDouble(decodificadorEnlaces[4].trim());
                Double userData = Double.parseDouble(decodificadorEnlaces[5].trim());

                Link link = new Link(
                        sourceNode,
                        destinyNode,
                        speed,
                        distance,
                        controlData,
                        userData
                );

                if (this.linksList != null) {
                    this.linksList.add(link);
                }
            }

            //Obtener Tamaño del paquete
            this.packageSize = Double.parseDouble(scanner.nextLine().trim());

            //Obtener Nodos Origen - Destino
            String[] decodificadorNodosOD = scanner.nextLine().split(",");
            this.sourceNode = this.nodeList[Integer.parseInt(decodificadorNodosOD[0].trim())];
            this.destinyNode = this.nodeList[Integer.parseInt(decodificadorNodosOD[1].trim())];

        } catch (Exception ex) {
            System.out.println("error al abrir archivo: Formato de archivo inválido\n" + ex);
        }

    }

    @Override
    public String toString() {
        String value = "\nNetwork Data";
        value += "\npackageSize: " + this.packageSize;
        value += "\nsourceNode: " + this.sourceNode;
        value += "\nDestinyNode: " + this.destinyNode;
        
        for(int i = 0; i < this.nodeList.length; i++){
            value += "\n" + this.nodeList[i];
        }
        
        for(int i = 0; i < this.linksList.size(); i++){
            value += "\n" + this.linksList.get(i);
        }
        
        value += "\n*********************************";

        return value;
    }

}
