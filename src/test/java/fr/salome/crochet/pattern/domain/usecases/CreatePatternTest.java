package fr.salome.crochet.pattern.domain.usecases;

import fr.salome.crochet.pattern.domain.entities.Pattern;
import fr.salome.crochet.pattern.domain.ports.PatternRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class CreatePatternTest {

	PatternRepositoryPort repository;
	CreatePattern createPattern;

	@BeforeEach
	void setup() {
		repository = mock(PatternRepositoryPort.class);
		createPattern = new CreatePattern(repository);
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"test", "12345@-/\\|<>"})
	void shouldCreatePattern(String name) {
		final var created = Pattern.create(name);

		assertThat(created).isNotNull()
				.extracting(Pattern::name)
				.isEqualTo(name);
	}
}
