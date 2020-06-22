package pl.rafalab.rozkladeobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteRequest {
    private Date date;
    private String source;
    private String destination;
}
