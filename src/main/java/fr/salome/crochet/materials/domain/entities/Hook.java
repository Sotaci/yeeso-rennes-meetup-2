package fr.salome.crochet.materials.domain.entities;

import fr.salome.crochet.materials.domain.entities.values.HookId;
import fr.salome.crochet.materials.domain.entities.values.HookSize;

public class Hook {
	private final HookId id;
	private final HookSize size;

	public Hook(HookId id, HookSize size) {
		this.id = id;
		this.size = size;
	}
}
