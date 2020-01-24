package latenciaredes.Model;

import java.util.List;
import latenciaredes.Interfaces.INetworkService;
import static latenciaredes.Model.CONSTANTS.SPEED_OF_LIGHT;

public class NetworkService implements INetworkService {

    @Override
    public Double calculteLatency(Way way) {
        int packageNumber = 1;
        int counter = 1;
        
        Double previousUserData = 0.0;
        
        Double latency = 0.0;
        
        for (Link link : way.getLinkList()) {
            if(counter == 1) previousUserData = link.getUserData();
            
            Double propagationTime
                    = UnitsUtil.metersToKilometres(link.getDistance()) / SPEED_OF_LIGHT;
            
            Double packageSize = link.getControlData() + link.getUserData();

            Double transferTime = UnitsUtil.bytesToMegabits(packageSize) / link.getSpeed();
            
            packageNumber = (int) Math.ceil((previousUserData * packageNumber) / link.getUserData());
            
            previousUserData = link.getUserData();
            
            latency += (packageNumber * (propagationTime + transferTime)) + 
                    (packageNumber * link.getDestinyNode().getQueuingDelay());
            
            counter++;
        }

        return latency;
    }

    @Override
    public List<Way> calculateLatencies(List<Way> listWays) {
        
        for(Way way : listWays){
            Double latency = calculteLatency(way);
            way.setLatency(latency);
        }
        
        return listWays;
    }

    @Override
    public Way getBestWay(List<Way> listWays) {
        Way bestWay = new Way();
        int counter = 1;
        
        for(Way way:listWays){
            if(counter == 1){
                bestWay = way;
            }else if(way.getLatency() < bestWay.getLatency()){
               bestWay = way;
            }
            
            counter++;
        }
        
        return bestWay;
    }

    @Override
    public Double getTransferTime(int packagesNumber, Double latency) {
        return packagesNumber * latency;
    }

    @Override
    public int getPackagesNumber(Double packageSize, Double userDataSize) {
        return (int) (Math.ceil(UnitsUtil.gygabytesToBytes(packageSize) / userDataSize));
    }

}
