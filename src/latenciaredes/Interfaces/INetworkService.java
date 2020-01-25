package latenciaredes.Interfaces;

import java.util.List;
import latenciaredes.Model.Way;

public interface INetworkService {
    public Double calculteLatency(Way way);
    public List<Way> calculateLatencies(List<Way> listWays);
    public Way getBestWay(List<Way> listWays);
    public Double getTransferTime(int packagesNumber, Double latency);
    public int getPackagesNumber(Double packageSize, Double userDataSize);
}
