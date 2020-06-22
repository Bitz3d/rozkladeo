package pl.rafalab.rozkladeobackend.service.connectedBusStopsService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rafalab.rozkladeobackend.model.BusStop;
import pl.rafalab.rozkladeobackend.model.ConnectedBusStop;
import pl.rafalab.rozkladeobackend.repository.BusStopRepository;
import pl.rafalab.rozkladeobackend.repository.ConnectedBusStopRepository;
import pl.rafalab.rozkladeobackend.service.busStop.BusStopService;
import pl.rafalab.rozkladeobackend.service.route.Edge;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConnectedBusStopServiceImpl implements ConnectedBusStopService {

    private final ConnectedBusStopRepository connectedBusStopRepository;
    private final BusStopService busStopService;

    @Override
    public List<Edge> getAllConnections(List<BusStop> busStops) {
        List<Edge> edges = new ArrayList<>();

        busStops.forEach(busStop -> {
            List<ConnectedBusStop> allByBusStop = connectedBusStopRepository.findAllByBusStop(busStop);
            allByBusStop.forEach(connectedBusStop -> {
                Edge edge = new Edge(connectedBusStop.getDistanceInMinutes(), busStop, busStopService.getBusStop(connectedBusStop.getBusStopName()));
                edges.add(edge);
            });
        });

        return edges;
    }
}
