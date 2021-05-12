package shop.ottmeal.batch.module.movie.job.latest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



public class ProductionCountry {

    private final String iso_3166_1;
    private final String name;
}
