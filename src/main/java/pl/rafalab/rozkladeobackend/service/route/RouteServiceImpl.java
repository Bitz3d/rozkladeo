package pl.rafalab.rozkladeobackend.service.route;

import org.springframework.stereotype.Service;
import pl.rafalab.rozkladeobackend.model.BusStop;

import java.util.*;

@Service
public class RouteServiceImpl implements RouteService {
    private List<Edge> edges;
    private Set<BusStop> settledBusStops;
    private Set<BusStop> unSettledBusStops;
    private Map<BusStop, BusStop> predecessors;
    private Map<BusStop, Integer> distance;

    public void execute(BusStop source, BusStationsGraph graph) {
        this.edges = new ArrayList<>(graph.getEdges());
        settledBusStops = new HashSet<>();
        unSettledBusStops = new HashSet<>();
        distance = new HashMap<>();
        predecessors = new HashMap<>();
        distance.put(source, 0);
        unSettledBusStops.add(source);
        while (unSettledBusStops.size() > 0) {
            BusStop node = getMinimum(unSettledBusStops);
            settledBusStops.add(node);
            unSettledBusStops.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(BusStop node) {
        List<BusStop> adjacentNodes = getNeighbors(node);
        for (BusStop target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node)
                        + getDistance(node, target));
                predecessors.put(target, node);
                unSettledBusStops.add(target);
            }
        }

    }

    private int getDistance(BusStop node, BusStop target) {
        for (Edge edge : edges) {
            if (edge.getSource().equals(node)
                    && edge.getDestination().equals(target)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private List<BusStop> getNeighbors(BusStop node) {
        List<BusStop> neighbors = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getSource().equals(node)
                    && !isSettled(edge.getDestination())) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private BusStop getMinimum(Set<BusStop> vertexes) {
        BusStop minimum = null;
        for (BusStop vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(BusStop vertex) {
        return settledBusStops.contains(vertex);
    }

    private int getShortestDistance(BusStop destination) {
        Integer d = distance.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    public LinkedList<BusStop> getPath(BusStop target) {
        LinkedList<BusStop> path = new LinkedList<>();
        BusStop step = target;

        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }

        Collections.reverse(path);
        return path;
    }
}
