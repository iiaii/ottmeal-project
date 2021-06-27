package shop.ottmeal.common.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public class BaseUser extends BaseEntity {

    @Column(name = "userId")
    protected String userId;

    @Column(name = "email")
    protected String email;

    @Column(name = "profileImage")
    protected String profileImage;
}
