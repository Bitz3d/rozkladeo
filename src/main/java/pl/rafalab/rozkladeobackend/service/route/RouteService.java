package pl.rafalab.rozkladeobackend.service.route;

import pl.rafalab.rozkladeobackend.model.BusStop;

import java.util.LinkedList;

public interface RouteService {
    void execute(BusStop source, BusStationsGraph graph);

    LinkedList<BusStop> getPath(BusStop target);
}
