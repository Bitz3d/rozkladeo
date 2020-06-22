package pl.rafalab.rozkladeobackend.service.busStop;

import pl.rafalab.rozkladeobackend.model.BusStop;

import java.util.List;

public interface BusStopService {
    BusStop getBusStop(String name);

    List<BusStop> findAllBusStops();
}
