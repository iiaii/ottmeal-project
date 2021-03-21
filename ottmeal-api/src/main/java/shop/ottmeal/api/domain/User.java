package shop.ottmeal.api.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.ottmeal.common.domain.BaseUser;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")
@Slf4j
public class User extends BaseUser {

    @Builder
    public User(Long idx, String userId, String email, String profileImage, List<Rating> ratings, List<Review> reviews) {
        super(idx, userId, email, profileImage);
        this.ratings = ratings;
        this.reviews = reviews;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Rating> ratings;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Review> reviews;
}
