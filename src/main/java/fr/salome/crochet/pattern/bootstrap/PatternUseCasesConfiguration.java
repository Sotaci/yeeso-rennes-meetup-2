package fr.salome.crochet.pattern.bootstrap;

import fr.salome.crochet.pattern.domain.ports.PatternRepositoryPort;
import fr.salome.crochet.pattern.domain.usecases.CrudPattern;
import fr.salome.crochet.pattern.domain.usecases.PublishPatternForTest;
import fr.salome.crochet.pattern.domain.usecases.PublishPatternForSale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatternUseCasesConfiguration {

	@Bean
	public CrudPattern crudPattern(PatternRepositoryPort repository) {
		return new CrudPattern(repository);
	}

	@Bean
	public PublishPatternForSale publishPatternForSale(PatternRepositoryPort repository) {
		return new PublishPatternForSale(repository);
	}

	@Bean
	public PublishPatternForTest publishPatternForTest(PatternRepositoryPort repository) {
		return new PublishPatternForTest(repository);
	}
}

