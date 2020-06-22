package pl.rafalab.rozkladeobackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConnectedBusStop {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private Integer distanceInMinutes;

    @NotEmpty(message = "Name may not be empty")
    private String busStopName;

    @ManyToOne()
    @JoinColumn(name = "bus_stop_id")
    private BusStop busStop;
}
