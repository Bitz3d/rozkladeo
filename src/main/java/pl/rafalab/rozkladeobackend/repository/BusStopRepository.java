package pl.rafalab.rozkladeobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rafalab.rozkladeobackend.model.BusStop;

import java.util.Optional;

public interface BusStopRepository extends JpaRepository<BusStop, Long> {
    Optional<BusStop> findByName(String name);
}
