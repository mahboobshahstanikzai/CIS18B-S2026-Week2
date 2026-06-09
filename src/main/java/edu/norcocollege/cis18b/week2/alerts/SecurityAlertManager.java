package edu.norcocollege.cis18b.week2.alerts;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Manages a collection of SecurityAlert objects.
 * Demonstrates modern Java features: Optional, Streams, switch expressions,
 * pattern matching with instanceof, and var.
 */
public class SecurityAlertManager {

    // Store alerts in an internal List
    private final List<SecurityAlert> alerts = new ArrayList<>();

    /**
     * Adds a new alert to the manager.
     * Rejects null alerts.
     *
     * @param alert the SecurityAlert to add (cannot be null)
     * @throws IllegalArgumentException if alert is null
     */
    public void addAlert(SecurityAlert alert) {
        if (alert == null) {
            throw new IllegalArgumentException("Alert cannot be null");
        }
        alerts.add(alert);
    }

    /**
     * Finds an alert by its ID.
     * Uses Streams and Optional to find the first match.
     *
     * @param id the alert ID to search for
     * @return Optional containing the alert if found, empty otherwise
     */
    public Optional<SecurityAlert> findById(String id) {
        if (id == null) {
            return Optional.empty();
        }
        // Using var for local variable type inference
        var found = alerts.stream()
            .filter(alert -> alert.id().equals(id))
            .findFirst();
        return found;
    }

    /**
     * Finds all alerts with the given severity.
     * Uses Streams to filter by severity.
     *
     * @param severity the severity to filter by (LOW, MEDIUM, HIGH, CRITICAL)
     * @return List of matching alerts (empty list if none found or severity is null)
     */
    public List<SecurityAlert> findBySeverity(String severity) {
        if (severity == null) {
            return new ArrayList<>();
        }
        // Using Streams for filtering
        return alerts.stream()
            .filter(alert -> alert.severity().equals(severity))
            .collect(Collectors.toList());
    }

    /**
     * Removes an alert by its ID.
     *
     * @param id the ID of the alert to remove
     * @return true if an alert was removed, false otherwise
     */
    public boolean removeAlert(String id) {
        if (id == null) {
            return false;
        }
        return alerts.removeIf(alert -> alert.id().equals(id));
    }

    /**
     * Returns a severity recommendation using a modern switch expression.
     * Demonstrates pattern matching with instanceof and modern switch expression syntax.
     *
     * @param alert the SecurityAlert to evaluate (cannot be null)
     * @return recommendation string based on severity
     * @throws IllegalArgumentException if alert is null or has unknown severity
     */
    public String getSeverityRecommendation(SecurityAlert alert) {
        // Pattern matching with instanceof demonstration
        if (!(alert instanceof SecurityAlert)) {
            throw new IllegalArgumentException("Expected SecurityAlert object");
        }
        
        // Modern switch expression (no fallthrough, returns value directly)
        return switch (alert.severity()) {
            case "LOW" -> "Log and monitor.";
            case "MEDIUM" -> "Investigate within 24 hours.";
            case "HIGH" -> "Escalate to engineering.";
            case "CRITICAL" -> "Immediate incident response required.";
            default -> throw new IllegalArgumentException("Unknown severity: " + alert.severity());
        };
    }
    
    /**
     * Returns the total number of alerts in the manager.
     * Helper method for the demo app.
     *
     * @return total alert count
     */
    public int getTotalAlerts() {
        return alerts.size();
    }
}