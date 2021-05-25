package shop.ottmeal.batch.domain;

public abstract class BaseMedia <T> {

    public abstract <Dto> T toEntity(Dto dto);
}
