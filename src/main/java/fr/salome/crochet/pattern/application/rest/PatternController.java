package fr.salome.crochet.pattern.application.rest;

import fr.salome.crochet.pattern.application.rest.request.CreatePatternRequest;
import fr.salome.crochet.pattern.application.rest.request.PublishPatternRequest;
import fr.salome.crochet.pattern.application.rest.request.UpdateGaugeRequest;
import fr.salome.crochet.pattern.application.rest.request.UpdateInstructionsRequest;
import fr.salome.crochet.pattern.application.rest.request.UpdateNameRequest;
import fr.salome.crochet.pattern.application.rest.request.UpdateYarnsRequest;
import fr.salome.crochet.pattern.application.rest.response.PatternResponse;
import fr.salome.crochet.pattern.domain.entities.values.Gauge;
import fr.salome.crochet.pattern.domain.entities.values.PatternId;
import fr.salome.crochet.pattern.domain.exceptions.PatternDomainException;
import fr.salome.crochet.pattern.domain.exceptions.PatternNotFoundException;
import fr.salome.crochet.pattern.domain.exceptions.PatternValidationException;
import fr.salome.crochet.pattern.domain.usecases.CrudPattern;
import fr.salome.crochet.pattern.domain.usecases.PublishPatternForSale;
import fr.salome.crochet.pattern.domain.usecases.UpdateMaterials;
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

	private final CrudPattern crudPattern;
	private final PublishPatternForSale publishPatternForSale;
	private final UpdateMaterials updateMaterials;

	public PatternController(
			CrudPattern crudPattern, PublishPatternForSale publishPatternForSale, UpdateMaterials updateMaterials
	) {
		this.crudPattern = crudPattern;
		this.publishPatternForSale = publishPatternForSale;
		this.updateMaterials = updateMaterials;
	}

	@PostMapping
	public ResponseEntity<PatternResponse> create(@RequestBody CreatePatternRequest request) throws PatternValidationException {
		final var created = crudPattern.create(request.name());

		return ResponseEntity.ok(PatternResponse.fromEntity(created));
	}

	@PostMapping("{id}/publish")
	public ResponseEntity<PatternResponse> publish(@PathVariable UUID id, @RequestBody PublishPatternRequest request) throws PatternNotFoundException, PatternDomainException, PatternValidationException {
		final var published = publishPatternForSale.execute(new PatternId(id), request.price());

		return ResponseEntity.ok(PatternResponse.fromEntity(published));
	}

	@GetMapping("/{id}")
	public ResponseEntity<PatternResponse> findById(@PathVariable UUID id) throws PatternNotFoundException {
		return ResponseEntity.ok(PatternResponse.fromEntity(crudPattern.getById(new PatternId(id))));
	}

	@PutMapping("/{id}/name")
	public ResponseEntity<PatternResponse> updateName(@PathVariable UUID id, @RequestBody UpdateNameRequest request) throws PatternDomainException, PatternValidationException, PatternNotFoundException {
		return ResponseEntity.ok(PatternResponse.fromEntity(crudPattern.updateName(new PatternId(id), request.name())));
	}

	@PutMapping("/{id}/gauge")
	public ResponseEntity<PatternResponse> updateGauge(@PathVariable UUID id, @RequestBody UpdateGaugeRequest request) throws PatternDomainException, PatternNotFoundException {
		final var updated = crudPattern.updateGauge(new PatternId(id), Gauge.of(request.nbStitches(), request.nbRows(), request.width(), request.height()));

		return ResponseEntity.ok(PatternResponse.fromEntity(updated));
	}

	@PutMapping("/{id}/instructions")
	public ResponseEntity<PatternResponse> updateInstructions(@PathVariable UUID id, @RequestBody UpdateInstructionsRequest instructions) throws PatternDomainException, PatternValidationException, PatternNotFoundException {
		final var updated = crudPattern.updateInstruction(new PatternId(id), instructions.index(), instructions.content());

		return ResponseEntity.ok(PatternResponse.fromEntity(updated));
	}

	@PutMapping("/{id}/yarns")
	public ResponseEntity<PatternResponse> updateYarns(@PathVariable UUID id, @RequestBody UpdateYarnsRequest request) throws PatternDomainException, PatternValidationException, PatternNotFoundException {
		final var updated = updateMaterials.updateYarns(new PatternId(id), request.yarnIds());

		return ResponseEntity.ok(PatternResponse.fromEntity(updated));
	}
}
