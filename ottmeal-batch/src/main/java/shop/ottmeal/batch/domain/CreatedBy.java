package shop.ottmeal.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class CreatedBy {

    @Id
    @GeneratedValue
    private Long idx;
    private Long id;
    private String creditId;
    private String name;
    private Integer gender;
    private String profilePath;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tv_idx")
    private Tv tv;

    @Builder
    public CreatedBy(Long id, String creditId, String name, int gender, String profilePath) {
        this.id = id;
        this.creditId = creditId;
        this.name = name;
        this.gender = gender;
        this.profilePath = profilePath;
    }


}
