package shop.ottmeal.batch.module.trending.job.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.ottmeal.batch.domain.Network;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NetworkResponse {

    private String name;
    private String logoPath;
    private String originCountry;

    public Network toEntity() {
        return Network.builder()
                .name(this.name)
                .logoPath(this.logoPath)
                .originCountry(this.originCountry)
                .build();
    }
}
