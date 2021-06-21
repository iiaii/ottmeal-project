package shop.ottmeal.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Network {

    @Id @GeneratedValue
    private Long idx;
    private String name;
    private String logoPath;
    private String originCountry;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tv_idx")
    private Tv tv;

    @Builder
    public Network(String name, String logoPath, String originCountry) {
        this.name = name;
        this.logoPath = logoPath;
        this.originCountry = originCountry;
    }
}
