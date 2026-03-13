package fr.salome.crochet.materials.application;

import fr.salome.crochet.materials.MaterialsApi;
import fr.salome.crochet.materials.domain.usecases.ValidateMaterialsIds;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MaterialsAdapter implements MaterialsApi {

	private final ValidateMaterialsIds validateMaterialsIds;

	public MaterialsAdapter(ValidateMaterialsIds validateMaterialsIds) {
		this.validateMaterialsIds = validateMaterialsIds;
	}

	@Override
	public boolean yarnsExist(List<UUID> yarnIds) {
		return validateMaterialsIds.yarnsExist(yarnIds);
	}

	@Override
	public boolean hooksExist(List<UUID> hookIds) {
		return validateMaterialsIds.hooksExist(hookIds);
	}
}
