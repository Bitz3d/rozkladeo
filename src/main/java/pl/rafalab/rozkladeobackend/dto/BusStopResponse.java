package pl.rafalab.rozkladeobackend.dto;

import lombok.Data;
import pl.rafalab.rozkladeobackend.model.BusStop;

@Data
public class BusStopResponse {
    public BusStopResponse(BusStop busStop) {
        this.name = busStop.getName();
    }

    private String name;
}
