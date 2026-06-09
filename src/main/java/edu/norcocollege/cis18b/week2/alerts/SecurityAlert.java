package edu.norcocollege.cis18b.week2.alerts;

/**
 * SecurityAlert record representing a cybersecurity alert.
 * This record is immutable by design (all record fields are final).
 */
public record SecurityAlert(
    String id,
    String sourceSystem,
    String severity,
    String description,
    long timestamp
) {
    // Compact constructor for basic validation (not enforcing specific severity values)
    public SecurityAlert {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID cannot be null or blank");
        }
        if (sourceSystem == null || sourceSystem.isBlank()) {
            throw new IllegalArgumentException("Source system cannot be null or blank");
        }
        if (severity == null || severity.isBlank()) {
            throw new IllegalArgumentException("Severity cannot be null or blank");
        }
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null");
        }
        if (timestamp <= 0) {
            throw new IllegalArgumentException("Timestamp must be positive");
        }
        // NOTE: We do NOT validate severity values here because:
        // 1. The test expects to test unknown severity handling in getSeverityRecommendation
        // 2. The manager's getSeverityRecommendation handles the validation
    }
}
