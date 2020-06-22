package pl.rafalab.rozkladeobackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.rafalab.rozkladeobackend.dto.BusStopResponse;
import pl.rafalab.rozkladeobackend.repository.BusStopRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class BusStopRestController {

    private final BusStopRepository busStopRepository;

    public BusStopRestController(BusStopRepository busStopRepository) {
        this.busStopRepository = busStopRepository;
    }

    @GetMapping("busStops")
    List<BusStopResponse> getBusStops() {
        return busStopRepository.findAll().stream().map(BusStopResponse::new).collect(toList());
    }
}
