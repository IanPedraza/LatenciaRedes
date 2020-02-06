package latenciaredes.View;

import java.util.List;
import java.util.Scanner;
import latenciaredes.Model.Graph;
import latenciaredes.Model.NetworkData;
import latenciaredes.Model.NetworkService;
import latenciaredes.Model.UnitsUtil;
import latenciaredes.Model.Way;

public class Main {

    public static void main(String[] args) {
        //nombre de archivo de prueba test.txt
        
        String path = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduzca la ruta del archivo:");
        path = scanner.nextLine();

        if (validatePath(path)) {
            calculate(path);
        }else{
            System.out.println("Error: Ruta inválida");
        }

    }

    public static void calculate(String path) {
        NetworkData networkData = new NetworkData();
        NetworkService networkService = new NetworkService();

        if (networkData.loadData(path)) {
            Graph graph = new Graph(networkData.getNodeList().length);
            graph.addLinkList(networkData.getLinksList());

            List<Way> ways = graph.getAllWays(
                    networkData.getSourceNode(),
                    networkData.getDestinyNode()
            );

            ways = networkService.calculateLatencies(ways);

            System.out.println("********** Lista de Caminos **********");

            for (Way way : ways) {
                System.out.println(way);
            }

            Way bestWay = networkService.getBestWay(ways);

            Double userDataBytes = bestWay.getLinkList().get(0).getUserData();

            int packagesNumber = networkService.getPackagesNumber(
                    networkData.getPackageSize(),
                    userDataBytes
            );

            Double transferTime = networkService.getTransferTime(packagesNumber, bestWay.getLatency());

            System.out.println("********** Mejor Camino **********");
            System.out.println(bestWay);
            System.out.println("Tiempo de transferencia: " + UnitsUtil.secondsToHoursFormat(transferTime));
        } else {
            System.out.println("Archivo Inválido");
        }
    }
    
    public static Boolean validatePath(String path){
        return path != null &&
                path.trim().length() > 4;
    }

}
