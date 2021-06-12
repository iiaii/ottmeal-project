package shop.ottmeal.batch.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Network {

    @Id @GeneratedValue
    private Long idx;
    private String name;
    private String logoPath;
    private String originCountry;
}
