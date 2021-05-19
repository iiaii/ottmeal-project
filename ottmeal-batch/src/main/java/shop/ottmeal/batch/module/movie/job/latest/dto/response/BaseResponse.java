package shop.ottmeal.batch.module.movie.job.latest.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public abstract class BaseResponse <T> {

    private List<T> results;
}
