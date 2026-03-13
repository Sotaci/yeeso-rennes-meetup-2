package fr.salome.crochet.pattern.bootstrap;

import fr.salome.crochet.pattern.domain.ports.PatternRepositoryPort;
import fr.salome.crochet.pattern.domain.usecases.CreatePattern;
import fr.salome.crochet.pattern.domain.usecases.GetPatternById;
import fr.salome.crochet.pattern.domain.usecases.UpdatePatternGauge;
import fr.salome.crochet.pattern.domain.usecases.UpdatePatternInstructions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatternUseCasesConfiguration {

	/*@Bean
	public GetPatternById getPatternByIdUseCase(PatternRepositoryPort patternRepository) {
		return new GetPatternById(patternRepository);
	}

	@Bean
	public CreatePattern createPatternUseCase(PatternRepositoryPort patternRepository) {
		return new CreatePattern(patternRepository);
	}

	@Bean
	public UpdatePatternGauge updatePatternGaugeUseCase(PatternRepositoryPort patternRepository) {
		return new UpdatePatternGauge(patternRepository);
	}

	@Bean
	public UpdatePatternInstructions updatePatternInstructionsUseCase(PatternRepositoryPort patternRepository) {
		return new UpdatePatternInstructions(patternRepository);
	}*/
}

