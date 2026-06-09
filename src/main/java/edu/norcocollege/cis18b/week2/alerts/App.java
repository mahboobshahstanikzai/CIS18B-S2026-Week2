package edu.norcocollege.cis18b.week2.alerts;

public class App {
    public static void main(String[] args) {
        SecurityAlertManager manager = new SecurityAlertManager();

        // Create alerts
        var alert1 = new SecurityAlert("A001", "Firewall", "HIGH", 
            "Multiple failed login attempts", System.currentTimeMillis());
        var alert2 = new SecurityAlert("A002", "IDS", "CRITICAL", 
            "SQL injection detected", System.currentTimeMillis());
        var alert3 = new SecurityAlert("A003", "Antivirus", "LOW", 
            "Suspicious file quarantined", System.currentTimeMillis());

        // Add to manager
        manager.addAlert(alert1);
        manager.addAlert(alert2);
        manager.addAlert(alert3);

        // Query by severity
        System.out.println("HIGH severity alerts: " + manager.findBySeverity("HIGH").size());

        // Find by ID
        manager.findById("A002").ifPresent(a -> 
            System.out.println("Found: " + a.id()));

        // Print report using text block
        long total = manager.getAllAlerts().size();
        long highCount = manager.findBySeverity("HIGH").size();

        String report = """
            ╔═══════════════════════════════╗
            ║     SECURITY ALERT REPORT     ║
            ╠═══════════════════════════════╣
            ║  Total Alerts:      %4d       ║
            ║  HIGH Severity:     %4d       ║
            ╚═══════════════════════════════╝
            """.formatted(total, highCount);

        System.out.println(report);
    }
}