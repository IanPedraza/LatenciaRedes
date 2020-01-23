package latenciaredes.Model;

import java.util.ArrayList;
import java.util.List;
import latenciaredes.Interfaces.INetworkData;

public class NetworkData implements INetworkData{
    
    private Double packageSize;
    private Node sourceNode;
    private Node destinyNode;
    private List<Node> nodeList;
    private List<Link> linksList;

    public NetworkData() {
        this.packageSize = 0.0;
        this.sourceNode = new Node();
        this.destinyNode = new Node();
        this.nodeList = new ArrayList();
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

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
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
        
    }
    
}
