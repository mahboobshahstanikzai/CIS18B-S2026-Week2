package edu.norcocollege.cis18b.week2.alerts;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SecurityAlertManager {

    private final List<SecurityAlert> alerts = new ArrayList<>();

    public void addAlert(SecurityAlert alert) {
        if (alert == null) {
            throw new IllegalArgumentException("Alert cannot be null");
        }
        alerts.add(alert);
    }

    public Optional<SecurityAlert> findById(String id) {
        if (id == null) return Optional.empty();
        return alerts.stream()
            .filter(a -> id.equals(a.id()))
            .findFirst();
    }

    public List<SecurityAlert> findBySeverity(String severity) {
        if (severity == null) return List.of();
        return alerts.stream()
            .filter(a -> severity.equalsIgnoreCase(a.severity()))
            .toList();
    }

    public boolean removeAlert(String id) {
        if (id == null) return false;
        return alerts.removeIf(a -> id.equals(a.id()));
    }

    public String getSeverityRecommendation(SecurityAlert alert) {
        if (alert == null) {
            throw new IllegalArgumentException("Alert cannot be null");
        }
        if (!(alert instanceof SecurityAlert)) {
            throw new IllegalArgumentException("Not a SecurityAlert");
        }
        return switch (alert.severity().toUpperCase()) {
            case "LOW" -> "Log and monitor.";
            case "MEDIUM" -> "Investigate within 24 hours.";
            case "HIGH" -> "Escalate to engineering.";
            case "CRITICAL" -> "Immediate incident response required.";
            default -> throw new IllegalArgumentException("Unknown severity");
        };
    }
    
    public List<SecurityAlert> getAllAlerts() {
        return new ArrayList<>(alerts);
    }
}