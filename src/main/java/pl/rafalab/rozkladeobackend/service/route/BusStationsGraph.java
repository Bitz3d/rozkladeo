package pl.rafalab.rozkladeobackend.service.route;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.rafalab.rozkladeobackend.model.BusStop;

import java.util.List;

@AllArgsConstructor
@Getter
public class BusStationsGraph {
    private final List<BusStop> vertexes;
    private final List<Edge> edges;

}
