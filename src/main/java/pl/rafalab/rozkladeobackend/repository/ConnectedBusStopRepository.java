package pl.rafalab.rozkladeobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rafalab.rozkladeobackend.model.BusStop;
import pl.rafalab.rozkladeobackend.model.ConnectedBusStop;

import java.util.List;

public interface ConnectedBusStopRepository extends JpaRepository<ConnectedBusStop, Long> {
    List<ConnectedBusStop> findAllByBusStop(BusStop busStop);
}
