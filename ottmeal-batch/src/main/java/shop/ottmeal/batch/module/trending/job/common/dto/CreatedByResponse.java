package shop.ottmeal.batch.module.trending.job.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.ottmeal.batch.domain.CreatedBy;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedByResponse {

    private Long id;
    private String creditId;
    private String name;
    private Integer gender;
    private String profilePath;

    public CreatedBy toEntity() {
        return CreatedBy.builder()
                .id(this.id)
                .creditId(this.creditId)
                .name(this.name)
                .gender(this.gender)
                .profilePath(this.profilePath)
                .build();
    }
}
