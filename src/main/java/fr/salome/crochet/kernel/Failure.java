package fr.salome.crochet.kernel;

import java.util.List;

public record Failure<T>(List<String> errors) implements Result<T> {}
