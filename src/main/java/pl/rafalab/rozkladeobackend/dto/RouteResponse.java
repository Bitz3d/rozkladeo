package pl.rafalab.rozkladeobackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.rafalab.rozkladeobackend.model.BusStop;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class RouteResponse implements Serializable {
    String sourceBusStop;
    List<String> intermediateBusStops;
    String destinationBusStop;

    public RouteResponse(LinkedList<BusStop> busStopList) {
        if (busStopList == null) {
            throw new RuntimeException("Connection doesn't exist!");
        }
        this.sourceBusStop = busStopList.get(0).getName();
        this.destinationBusStop = busStopList.get(busStopList.size() - 1).getName();
        busStopList.remove(0);
        busStopList.remove(busStopList.size() - 1);
        this.intermediateBusStops = busStopList.stream().map(BusStop::getName).collect(Collectors.toList());
    }
}
