package shop.ottmeal.batch.module.trending.job.tv.step.writer;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import shop.ottmeal.batch.domain.*;
import shop.ottmeal.batch.repository.*;

import java.util.List;

@RequiredArgsConstructor
public class TrendingTvItemWriter implements ItemWriter<Tv> {

    private final TvRepository tvRepository;
    private final GenreRepository genreRepository;
    private final ProductionCompanyRepository productionCompanyRepository;
    private final ProductionCountryRepository productionCountryRepository;
    private final SpokenLanguageRepository spokenLanguageRepository;
    private final EpisodeToAirRepository episodeToAirRepository;
    private final NetworkRepository networkRepository;
    private final SeasonRepository seasonRepository;

    @Override
    public void write(List<? extends Tv> tvs) throws Exception {
        tvs.stream().forEach(this::saveAll);
    }

    private void saveAll(Tv tv) {
        tvRepository.save(tv);
        genreRepository.saveAll(tv.getGenres());
        productionCompanyRepository.saveAll(tv.getProductionCompanies());
        productionCountryRepository.saveAll(tv.getProductionCountries());
        spokenLanguageRepository.saveAll(tv.getSpokenLanguages());
        episodeToAirRepository.save(tv.getNextEpisodeToAir());
        episodeToAirRepository.save(tv.getLastEpisodeToAir());
        networkRepository.saveAll(tv.getNetworks());
        seasonRepository.saveAll(tv.getSeasons());
    }
}
