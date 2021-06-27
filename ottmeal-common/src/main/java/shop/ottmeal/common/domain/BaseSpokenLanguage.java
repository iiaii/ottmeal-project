package shop.ottmeal.common.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public class BaseSpokenLanguage extends BaseEntity {

    protected String englishName;

    protected String iso_639_1;

    protected String name;
}