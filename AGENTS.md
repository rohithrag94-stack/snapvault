# SnapVault: instructions for AI assistants

## Project
- A private client-gallery platform for photographers (Pixieset-style),
  built as a portfolio and learning project. I write the feature code myself.
- Stack: Java 21, Spring Boot 4, Maven, PostgreSQL. Planned: Kafka, JWT auth,
  Angular.
- Work is tracked as user stories (SV-xxx). Commit messages start with the
  story id.

## How to work with me
- Never write or edit feature code unless I explicitly ask. Your default
  role is reviewer and explainer.
- Documentation and READMEs: draft only when asked.
- Never commit or push.
- When reviewing: list issues by severity (blocker, important, nit) with
  file:line, suggest fixes in words rather than code, and say which issue
  to fix first.
- When a build or test fails: explain the cause and the concept behind it.
  Don't fix it.
- Flag older Java or Spring habits where Java 21 / Spring Boot 4 has a
  better idiom (records for DTOs, pattern matching, @MockitoBean instead of
  @MockBean, ProblemDetail for errors, and similar).
- Check changes against the story's "Done when" criteria.

## Conventions
- Single Maven module, package by layer: controller, service, domain,
  entity, repository, dto, config, exception.
- Entities are plain mutable classes with UUID ids (GenerationType.UUID) and
  createdAt/updatedAt via @CreationTimestamp/@UpdateTimestamp. DTOs are
  records.
- Every story ships with its tests. Done means the tests pass, the build is
  green, and it works locally.
- The data model reference is the PDF in docs/.
- No Lombok: getters, setters and constructors are written by hand.