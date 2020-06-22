package pl.rafalab.rozkladeobackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BusStop {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "Name may not be empty")
    private String name;

    @OneToMany(
            mappedBy = "busStop",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<ConnectedBusStop> connectedBusStops;

    @Override
    public String toString() {
        return name;
    }
}
