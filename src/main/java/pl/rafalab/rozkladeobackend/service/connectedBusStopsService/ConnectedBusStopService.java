package pl.rafalab.rozkladeobackend.service.connectedBusStopsService;

import pl.rafalab.rozkladeobackend.model.BusStop;
import pl.rafalab.rozkladeobackend.service.route.Edge;

import java.util.List;

public interface ConnectedBusStopService {
    List<Edge> getAllConnections(List<BusStop> busStops);
}
