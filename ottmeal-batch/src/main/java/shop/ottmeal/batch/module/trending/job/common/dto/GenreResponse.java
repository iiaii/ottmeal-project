package shop.ottmeal.batch.module.trending.job.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.ottmeal.batch.domain.Genre;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenreResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    public Genre toEntity() {
        return Genre.builder()
                .id(this.id)
                .name(this.name)
                .build();
    }
}
