package edu.norcocollege.cis18b.week2.alerts;

/**
 * Entry point for the Cybersecurity Alert System demonstration.
 *
 * Creates multiple alerts, adds them to the manager,
 * demonstrates various operations, and prints a formatted report.
 */
public class App {

    public static void main(String[] args) {
        // Create SecurityAlertManager instance using var
        var manager = new SecurityAlertManager();

        // Create multiple SecurityAlert records with current timestamps
        var currentTime = System.currentTimeMillis();
        
        var alert1 = new SecurityAlert(
            "ALERT-001",
            "Web-Gateway",
            "HIGH",
            "Suspicious login attempt detected from unknown IP",
            currentTime - 3600000  // 1 hour ago
        );
        
        var alert2 = new SecurityAlert(
            "ALERT-002",
            "Database-Scanner",
            "CRITICAL",
            "SQL injection pattern detected in query logs",
            currentTime - 1800000  // 30 minutes ago
        );
        
        var alert3 = new SecurityAlert(
            "ALERT-003",
            "Auth-Service",
            "MEDIUM",
            "Multiple failed login attempts for admin account",
            currentTime - 7200000  // 2 hours ago
        );
        
        var alert4 = new SecurityAlert(
            "ALERT-004",
            "Network-Monitor",
            "LOW",
            "Unusual outbound traffic pattern detected",
            currentTime - 86400000  // 24 hours ago
        );
        
        var alert5 = new SecurityAlert(
            "ALERT-005",
            "Firewall",
            "HIGH",
            "Port scanning activity detected from external source",
            currentTime - 900000   // 15 minutes ago
        );

        // Add alerts to manager
        manager.addAlert(alert1);
        manager.addAlert(alert2);
        manager.addAlert(alert3);
        manager.addAlert(alert4);
        manager.addAlert(alert5);

        // Query by severity and print results
        System.out.println("\n--- HIGH Severity Alerts ---");
        var highAlerts = manager.findBySeverity("HIGH");
        for (var alert : highAlerts) {
            System.out.println("  ID: " + alert.id() + " - " + alert.description());
            System.out.println("    Recommendation: " + manager.getSeverityRecommendation(alert));
        }

        // Look up an alert by ID
        System.out.println("\n--- Looking up alert by ID: ALERT-002 ---");
        var foundAlert = manager.findById("ALERT-002");
        foundAlert.ifPresentOrElse(
            alert -> System.out.println("Found: " + alert.id() + " from " + alert.sourceSystem()),
            () -> System.out.println("Alert not found")
        );

        // Demonstrate getSeverityRecommendation for each severity
        System.out.println("\n--- Severity Recommendations ---");
        System.out.println("LOW: " + manager.getSeverityRecommendation(alert4));
        System.out.println("MEDIUM: " + manager.getSeverityRecommendation(alert3));
        System.out.println("HIGH: " + manager.getSeverityRecommendation(alert1));
        System.out.println("CRITICAL: " + manager.getSeverityRecommendation(alert2));

        // Print formatted report using a text block
        var total = manager.getTotalAlerts();
        var highCount = manager.findBySeverity("HIGH").size();
        var criticalCount = manager.findBySeverity("CRITICAL").size();
        
        // Using text block with formatted output
        System.out.println("\n" + """
            ╔══════════════════════════════════════════════════════════════╗
            ║                    SECURITY ALERT REPORT                     ║
            ╠══════════════════════════════════════════════════════════════╣
            ║  Total Alerts:        %-34d ║
            ║  High Severity:        %-34d ║
            ║  Critical Severity:    %-34d ║
            ╠══════════════════════════════════════════════════════════════╣
            ║  Alert IDs by Severity:                                      ║
            ║    HIGH:      ALERT-001, ALERT-005                          ║
            ║    CRITICAL:  ALERT-002                                      ║
            ║    MEDIUM:    ALERT-003                                      ║
            ║    LOW:       ALERT-004                                      ║
            ╚══════════════════════════════════════════════════════════════╝
            """.formatted(total, highCount, criticalCount));
        
        // Demonstrate removeAlert
        System.out.println("\n--- Removing alert ALERT-004 (LOW severity) ---");
        var wasRemoved = manager.removeAlert("ALERT-004");
        System.out.println("Alert removed: " + wasRemoved);
        System.out.println("Total alerts after removal: " + manager.getTotalAlerts());
    }
}