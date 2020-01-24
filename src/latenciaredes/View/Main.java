package latenciaredes.View;

import java.util.List;
import latenciaredes.Model.Graph;
import latenciaredes.Model.NetworkData;
import latenciaredes.Model.NetworkService;
import latenciaredes.Model.UnitsUtil;
import latenciaredes.Model.Way;

public class Main {

    public static void main(String[] args) {
        NetworkData networkData = new NetworkData();
        networkData.loadData("C:\\Users\\ianpe\\Desktop\\test.txt");

        Graph graph = new Graph(6);
        graph.addLinkList(networkData.getLinksList());

        List<Way> ways = graph.getAllWays(networkData.getSourceNode(), networkData.getDestinyNode());

        NetworkService networkService = new NetworkService();
        ways = networkService.calculateLatencies(ways);

        Way bestWay = networkService.getBestWay(ways);
        
        Double userDataBytes = bestWay.getLinkList().get(0).getUserData();
        
        int packagesNumber = networkService.getPackagesNumber(
                networkData.getPackageSize(),
                userDataBytes
        );
        
        Double transferTime = networkService.getTransferTime(packagesNumber, bestWay.getLatency());
        //transferTime = UnitsUtil.secondsToHours(transferTime);

        System.out.println(bestWay);
        System.out.println("Tiempo de transferencia: " + transferTime + " Seconds");
    }

    private static void printWays(List<Way> ways) {
        System.out.println("Size: " + ways.size());

        for (int i = 0; i < ways.size(); i++) {

            for (int j = 0; j < ways.get(i).getLinkList().size(); j++) {
                System.out.print(ways.get(i).getLinkList().get(j).getSourceNode().getNumber() + " -> ");
            }

            System.out.println("");
        }
    }

}
