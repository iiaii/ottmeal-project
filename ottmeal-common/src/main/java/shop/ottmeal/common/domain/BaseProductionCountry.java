package shop.ottmeal.common.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public class BaseProductionCountry extends BaseEntity {

    protected String iso_3166_1;

    protected String name;
}