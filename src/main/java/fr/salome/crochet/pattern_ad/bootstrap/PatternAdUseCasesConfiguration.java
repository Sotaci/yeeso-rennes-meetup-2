package fr.salome.crochet.pattern_ad.bootstrap;

import fr.salome.crochet.pattern_ad.domain.ports.PatternAdRepositoryPort;
import fr.salome.crochet.pattern_ad.domain.usecases.CreateAdFromPattern;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatternAdUseCasesConfiguration {

	@Bean
	public CreateAdFromPattern createAdFromPattern(PatternAdRepositoryPort repository) {
		return new CreateAdFromPattern(repository);
	}
}
