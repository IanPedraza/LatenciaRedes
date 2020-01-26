package latenciaredes.View;

import java.util.List;
import latenciaredes.Model.Graph;
import latenciaredes.Model.NetworkData;
import latenciaredes.Model.NetworkService;
import latenciaredes.Model.UnitsUtil;
import latenciaredes.Model.Way;

public class Main {
    /*
        *** MENU ***
        1. Abrir archivo
        2. Mostrar Todo
        3. Mostrar todos los caminos
        4. Calcular Latencias de los caminos
        5. Mostrar el mejor camino
        6. Mostrar el mejor tiempo de transferencia
    */
    
    public static void main(String[] args) {
        NetworkData networkData = new NetworkData();
        if (networkData.loadData("C:\\Users\\ianpe\\Desktop\\test.txt")) {
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
            transferTime = UnitsUtil.secondsToHours(transferTime);

            System.out.println(bestWay);
            System.out.println("Tiempo de transferencia: " + transferTime + " Hours");
        }else{
            System.out.println("Archivo Inválido");
        }
    }

}
