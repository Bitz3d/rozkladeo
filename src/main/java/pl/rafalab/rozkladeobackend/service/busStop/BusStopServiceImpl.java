package pl.rafalab.rozkladeobackend.service.busStop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rafalab.rozkladeobackend.model.BusStop;
import pl.rafalab.rozkladeobackend.repository.BusStopRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusStopServiceImpl implements BusStopService {
    private final BusStopRepository busStopRepository;

    public BusStop getBusStop(String name) {
        return busStopRepository.findByName(name).orElseThrow(() -> new RuntimeException("Bus Stop doesn't exist"));
    }

    public List<BusStop> findAllBusStops() {
        return busStopRepository.findAll();
    }
}
