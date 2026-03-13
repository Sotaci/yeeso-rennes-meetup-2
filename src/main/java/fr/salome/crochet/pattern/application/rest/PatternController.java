package fr.salome.crochet.pattern.application.rest;

import fr.salome.crochet.pattern.application.rest.request.CreatePatternRequest;
import fr.salome.crochet.pattern.application.rest.request.UpdateGaugeRequest;
import fr.salome.crochet.pattern.application.rest.request.UpdateInstructionsRequest;
import fr.salome.crochet.pattern.application.rest.response.PatternResponse;
import fr.salome.crochet.pattern.domain.usecases.CreatePattern;
import fr.salome.crochet.pattern.domain.usecases.GetPatternById;
import fr.salome.crochet.pattern.domain.usecases.UpdatePatternGauge;
import fr.salome.crochet.pattern.domain.usecases.UpdatePatternInstructions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/patterns")
public class PatternController {

	private final GetPatternById getPatternById;
	private final CreatePattern createPattern;
	private final UpdatePatternGauge updatePatternGauge;
	private final UpdatePatternInstructions updatePatternInstructions;

	public PatternController(
			GetPatternById getPatternById,
			CreatePattern createPattern,
			UpdatePatternGauge updatePatternGauge,
			UpdatePatternInstructions updatePatternInstructions
	) {
		this.getPatternById = getPatternById;
		this.createPattern = createPattern;
		this.updatePatternGauge = updatePatternGauge;
		this.updatePatternInstructions = updatePatternInstructions;
	}

	@PostMapping
	public ResponseEntity<PatternResponse> create(@RequestBody CreatePatternRequest request) {
		final var created = createPattern.execute(request.name());

		return ResponseEntity.ok(PatternResponse.fromEntity(created));
	}

	@GetMapping("/{id}")
	public ResponseEntity<PatternResponse> findById(@PathVariable UUID id) {
		return ResponseEntity.ok(PatternResponse.fromEntity(getPatternById.execute(id)));
	}

	@PutMapping("/{id}/gauge")
	public ResponseEntity<PatternResponse> updateGauge(@PathVariable UUID id, @RequestBody UpdateGaugeRequest gauge) {
		final var updated = updatePatternGauge.execute(id, UpdateGaugeRequest.toEntity(gauge));

		return ResponseEntity.ok(PatternResponse.fromEntity(updated));
	}

	@PutMapping("/{id}/instructions")
	public ResponseEntity<PatternResponse> updateInstructions(@PathVariable UUID id, @RequestBody UpdateInstructionsRequest instructions) {
		final var updated = updatePatternInstructions.execute(id, instructions.index(), instructions.content());

		return ResponseEntity.ok(PatternResponse.fromEntity(updated));
	}
}
