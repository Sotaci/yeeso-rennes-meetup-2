package fr.salome.crochet.pattern.infrastructure.persistence;

import fr.salome.crochet.materials.MaterialsApi;
import fr.salome.crochet.pattern.domain.exceptions.PatternDomainException;
import fr.salome.crochet.pattern.domain.ports.MaterialValidatorPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MaterialsValidatorAdapter implements MaterialValidatorPort {
	private final MaterialsApi materialsAPI;

	public MaterialsValidatorAdapter(MaterialsApi materialsAPI) {
		this.materialsAPI = materialsAPI;
	}

	@Override
	public void validateYarnIds(List<UUID> yarnIds) throws PatternDomainException {
		if (!materialsAPI.yarnsExist(yarnIds)) {
			throw PatternDomainException.invalidYarnIds();
		}
	}

	@Override
	public void validateHookIds(List<UUID> hookIds) throws PatternDomainException {
		if (!materialsAPI.hooksExist(hookIds)) {
			throw PatternDomainException.invalidHookIds();
		}
	}
}
