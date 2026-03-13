package fr.salome.crochet.kernel;

import java.util.List;

// Operation result pattern / Either pattern
public sealed interface Result<T> permits Success, Failure {
	static <T> Result<T> success(T content) {
		return new Success<>(content);
	}

	static <T> Result<T> failure(List<String> errors) {
		return new Failure<>(errors);
	}
}
