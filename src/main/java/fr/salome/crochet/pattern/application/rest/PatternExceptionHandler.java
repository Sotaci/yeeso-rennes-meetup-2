package fr.salome.crochet.pattern.application.rest;

import fr.salome.crochet.pattern.domain.exceptions.PatternDomainException;
import fr.salome.crochet.pattern.domain.exceptions.PatternNotFoundException;
import fr.salome.crochet.pattern.domain.exceptions.PatternValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "fr.salome.crochet.pattern")
public class PatternExceptionHandler {

	@ExceptionHandler(PatternNotFoundException.class)
	public ResponseEntity<PatternApiError> handlePatternNotFoundException(PatternNotFoundException ex) {
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(PatternApiError.notFound(ex.getMessage()));
	}

	@ExceptionHandler(PatternDomainException.class)
	public ResponseEntity<PatternApiError> handlePatternDomainException(PatternDomainException ex) {
		return ResponseEntity
				.status(HttpStatus.CONFLICT)
				.body(PatternApiError.conflict(ex.getMessage()));
	}

	@ExceptionHandler(PatternValidationException.class)
	public ResponseEntity<PatternApiError> handlePatternValidationException(PatternValidationException ex) {
		return ResponseEntity
				.badRequest()
				.body(PatternApiError.validationError(ex.getErrors()));
	}
}