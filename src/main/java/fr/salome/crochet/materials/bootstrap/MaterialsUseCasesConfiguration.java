package fr.salome.crochet.materials.bootstrap;

import fr.salome.crochet.materials.domain.ports.HookRepositoryPort;
import fr.salome.crochet.materials.domain.ports.YarnRepositoryPort;
import fr.salome.crochet.materials.domain.usecases.ValidateMaterialsIds;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MaterialsUseCasesConfiguration {

	@Bean
	public ValidateMaterialsIds validateMaterialsIds(HookRepositoryPort hookRepository, YarnRepositoryPort yarnRepository) {
		return new ValidateMaterialsIds(hookRepository, yarnRepository);
	}
}
