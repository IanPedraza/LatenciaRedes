package latenciaredes.Model;

public class Node {
    
    private int number;
    private Double queuingDelay;

    public Node(int number, Double queuingDelay) {
        this.number = number;
        this.queuingDelay = queuingDelay;
    }

    public Node() {
         this.number = -1;
        this.queuingDelay = 0.0;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Double getQueuingDelay() {
        return queuingDelay;
    }

    public void setQueuingDelay(Double queuingDelay) {
        this.queuingDelay = queuingDelay;
    }
    
}
