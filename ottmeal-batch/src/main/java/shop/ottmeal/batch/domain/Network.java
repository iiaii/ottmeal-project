package shop.ottmeal.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.ottmeal.common.domain.BaseNetwork;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Network extends BaseNetwork {

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tv_idx")
    private Tv tv;

    @Builder
    public Network(String name, String logoPath, String originCountry, Tv tv) {
        super(name, logoPath, originCountry);
        this.tv = tv;
    }
}
