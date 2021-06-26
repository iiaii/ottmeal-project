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
    private String credit_id;
    private String name;
    private Integer gender;
    private String profile_path;

    public CreatedBy toEntity() {
        return CreatedBy.builder()
                .id(this.id)
                .creditId(this.credit_id)
                .name(this.name)
                .gender(this.gender)
                .profilePath(this.profile_path)
                .build();
    }
}
