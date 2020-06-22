package pl.rafalab.rozkladeobackend.service.route;

import pl.rafalab.rozkladeobackend.model.BusStop;

public class Edge {

    private int weight;
    private BusStop source;
    private BusStop destination;

    public Edge(int weight, BusStop source, BusStop destination) {
        this.weight = weight;
        this.source = source;
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public BusStop getSource() {
        return source;
    }

    public void setSource(BusStop source) {
        this.source = source;
    }

    public BusStop getDestination() {
        return destination;
    }

    public void setDestination(BusStop destination) {
        this.destination = destination;
    }
}
