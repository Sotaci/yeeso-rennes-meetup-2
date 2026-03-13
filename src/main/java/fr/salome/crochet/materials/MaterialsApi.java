package fr.salome.crochet.materials;

import java.util.List;
import java.util.UUID;

public interface MaterialsApi {
	boolean yarnsExist(List<UUID> yarnIds);

	boolean hooksExist(List<UUID> hookIds);
}
