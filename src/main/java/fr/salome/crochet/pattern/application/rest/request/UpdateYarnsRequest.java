package fr.salome.crochet.pattern.application.rest.request;

import java.util.List;
import java.util.UUID;

public record UpdateYarnsRequest(List<UUID> yarnIds) {
}
