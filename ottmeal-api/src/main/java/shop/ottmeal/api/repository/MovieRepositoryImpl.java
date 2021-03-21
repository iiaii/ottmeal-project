package shop.ottmeal.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Optional;

public class MovieRepositoryImpl implements MovieRepositoryCustom {

//    private final JPAQueryFactory queryFactory;
//
//    @Autowired
//    public BrandTubeRepositoryImpl(@Qualifier("tvJpaQueryFactory") JPAQueryFactory queryFactory) { this.queryFactory = queryFactory; }

//    @Override
//    public Optional<BrandTube> findWithContentProviderByContentProviderIdxAndPlatformStationNo(final Long contentProviderIdx, final Long platformStationNo) {
//        return Optional.ofNullable(this.queryFactory.selectFrom(brandTube)
//                .innerJoin(brandTube.contentProvider, contentProvider)
//                .fetchJoin()
//                .where(brandTube.contentProviderIdx.eq(contentProviderIdx)
//                        .and(brandTube.platformStationNo.eq(platformStationNo)
//                                .and(brandTube.activation.isTrue())
//                                .and(contentProvider.activation.isTrue()))
//                ).fetchOne());
//    }

}
