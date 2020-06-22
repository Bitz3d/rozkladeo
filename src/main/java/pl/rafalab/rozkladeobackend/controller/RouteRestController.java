package pl.rafalab.rozkladeobackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.rafalab.rozkladeobackend.dto.RouteRequest;
import pl.rafalab.rozkladeobackend.dto.RouteResponse;
import pl.rafalab.rozkladeobackend.model.BusStop;
import pl.rafalab.rozkladeobackend.service.busStop.BusStopService;
import pl.rafalab.rozkladeobackend.service.connectedBusStopsService.ConnectedBusStopService;
import pl.rafalab.rozkladeobackend.service.route.BusStationsGraph;
import pl.rafalab.rozkladeobackend.service.route.Edge;
import pl.rafalab.rozkladeobackend.service.route.RouteServiceImpl;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RouteRestController {

    private final BusStopService busStopService;
    private final ConnectedBusStopService connectedBusStopService;
    private final RouteServiceImpl routeService;

    @GetMapping("/route")
    RouteResponse getRoute(@RequestBody RouteRequest routeRequest) {
        List<BusStop> busStops = busStopService.findAllBusStops();
        List<Edge> edges = connectedBusStopService.getAllConnections(busStops);
        BusStationsGraph busStationsGraph = new BusStationsGraph(busStops, edges);
        routeService.execute(busStopService.getBusStop(routeRequest.getSource()), busStationsGraph);
        LinkedList<BusStop> path = routeService.getPath(busStopService.getBusStop(routeRequest.getDestination()));
        return new RouteResponse(path);
    }
}
