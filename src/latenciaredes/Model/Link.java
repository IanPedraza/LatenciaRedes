package latenciaredes.Model;

public class Link {
    
    private Node sourceNode;
    private Node destinyNode;
    private Double speed;
    private Double distance;
    private Double controlData;
    private Double userData;

    public Link(Node sourceNode, Node destinyNode, Double speed, Double distance, Double controlData, Double userData) {
        this.sourceNode = sourceNode;
        this.destinyNode = destinyNode;
        this.speed = speed;
        this.distance = distance;
        this.controlData = controlData;
        this.userData = userData;
    }

    public Link() {
        this.sourceNode = new Node();
        this.destinyNode = new Node();
        this.speed = 0.0;
        this.distance = 0.0;
        this.controlData = 0.0;
        this.userData = 0.0;
    }
    
    public Link(Link link) {
        this.sourceNode = link.sourceNode;
        this.destinyNode = link.destinyNode;
        this.speed = link.speed;
        this.distance = link.distance;
        this.controlData = link.controlData;
        this.userData = link.userData;
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

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getControlData() {
        return controlData;
    }

    public void setControlData(Double controlData) {
        this.controlData = controlData;
    }

    public Double getUserData() {
        return userData;
    }

    public void setUserData(Double userData) {
        this.userData = userData;
    }
    
}
