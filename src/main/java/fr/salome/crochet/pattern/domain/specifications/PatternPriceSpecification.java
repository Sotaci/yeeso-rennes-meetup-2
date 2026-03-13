package fr.salome.crochet.pattern.domain.specifications;

import fr.salome.crochet.kernel.Result;
import fr.salome.crochet.kernel.Specification;

import java.util.List;

public class PatternPriceSpecification implements Specification<Long> {

	@Override
	public Result<Long> isSatisfiedBy(Long candidate) {
		if (candidate == null) {
			return Result.failure(List.of("Price cannot be null"));
		}

		if (candidate < 0) {
			return Result.failure(List.of("Price cannot be negative"));
		}

		if (candidate > 100) {
			return Result.failure(List.of("Are you for real?"));
		}

		return Result.success(candidate);
	}
}
