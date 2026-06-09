package edu.norcocollege.cis18b.week2.alerts;

/**
 * SecurityAlert record - immutable data carrier for security alerts
 */
public record SecurityAlert(
    String id,
    String sourceSystem,
    String severity,
    String description,
    long timestamp
) {
    // Compact constructor with validation
    public SecurityAlert {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID cannot be null or blank");
        }
        if (sourceSystem == null || sourceSystem.isBlank()) {
            throw new IllegalArgumentException("Source system cannot be null or blank");
        }
        String upperSeverity = severity.toUpperCase();
        if (!List.of("LOW", "MEDIUM", "HIGH", "CRITICAL").contains(upperSeverity)) {
            throw new IllegalArgumentException("Invalid severity: " + severity);
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or blank");
        }
        if (timestamp <= 0) {
            throw new IllegalArgumentException("Invalid timestamp");
        }
    }
}