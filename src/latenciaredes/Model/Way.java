package latenciaredes.Model;

import java.util.ArrayList;
import java.util.List;

public class Way {
    
    private List<Link> linkList;
    private Double latency;

    public Way(Way way){
        this.linkList = way.linkList;
        this.latency = way.latency;
    }
    
    public Way(List<Link> linkList, Double latency) {
        this.linkList = linkList;
        this.latency = latency;
    }
    
    public Way() {
        this.linkList = new ArrayList<>();
        this.latency = 0.0;
    }

    public List<Link> getLinkList() {
        return linkList;
    }

    public void setLinkList(List<Link> linkList) {
        this.linkList = linkList;
    }

    public Double getLatency() {
        return latency;
    }

    public void setLatency(Double latency) {
        this.latency = latency;
    }

    @Override
    public String toString() {
        String value = "";
        int count = 1;
        
        for(Link link:this.linkList){
            value += link.getSourceNode().getNumber() + "->";
            
            if(count == this.linkList.size())
                value += link.getDestinyNode().getNumber();
            
            count++;
        }
        
        value += "\tLatency: " + latency;
        value += "\n";
        
        return value;
    }
    
    
    
}
