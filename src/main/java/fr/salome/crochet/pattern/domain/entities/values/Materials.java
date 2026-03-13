package fr.salome.crochet.pattern.domain.entities.values;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public record Materials(List<UUID> yarnIds, List<UUID> hookIds) {
	public static Materials empty() {
		return new Materials(Collections.emptyList(), Collections.emptyList());
	}

	public static Materials of(List<UUID> yarnIds, List<UUID> hookIds) {
		return new Materials(
				yarnIds != null ? List.copyOf(yarnIds) : Collections.emptyList(),
				hookIds != null ? List.copyOf(hookIds) : Collections.emptyList()
		);
	}

	public Materials withYarns(List<UUID> yarnIds) {
		return new Materials(yarnIds, hookIds);
	}

	public Materials withHooks(List<UUID> hookIds) {
		return new Materials(yarnIds, hookIds);
	}
}
