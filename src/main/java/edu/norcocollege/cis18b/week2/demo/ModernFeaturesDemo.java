package edu.norcocollege.cis18b.week2.demo;

import java.util.List;
import java.util.Optional;

/**
 * This class demonstrates modern Java features (Java 17+):
 * - Record type
 * - Pattern matching with instanceof
 * - Switch expression
 * - Optional
 * - Stream operations
 * - Text blocks
 */
public class ModernFeaturesDemo {

    // 1. RECORD TYPE
    record Product(String name, double price, String category) {
    }

    public void demonstrate() {
        System.out.println("\n=== MODERN FEATURES DEMO ===\n");

        // 1. RECORD TYPE
        System.out.println("1. RECORD TYPE");
        Product laptop = new Product("Laptop", 1299.99, "Electronics");
        System.out.println("  Record: " + laptop);
        System.out.println("  Name: " + laptop.name());

        // 2. PATTERN MATCHING WITH INSTANCEOF
        System.out.println("\n2. PATTERN MATCHING WITH INSTANCEOF");
        Object obj = "Hello Java!";
        if (obj instanceof String s) {
            System.out.println("  String length: " + s.length());
        }

        // 3. SWITCH EXPRESSION
        System.out.println("\n3. SWITCH EXPRESSION");
        String severity = "HIGH";
        String recommendation = switch (severity) {
            case "LOW" -> "Log and monitor.";
            case "MEDIUM" -> "Investigate within 24 hours.";
            case "HIGH" -> "Escalate to engineering.";
            case "CRITICAL" -> "Immediate incident response required.";
            default -> "Unknown severity.";
        };
        System.out.println("  " + severity + ": " + recommendation);

        // 4. OPTIONAL
        System.out.println("\n4. OPTIONAL");
        Optional<String> optionalValue = Optional.of("Hello Optional!");
        optionalValue.ifPresent(val -> System.out.println("  Value: " + val));

        // 5. STREAM OPERATION
        System.out.println("\n5. STREAM OPERATION");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> evenSquares = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .toList();
        System.out.println("  Even squares: " + evenSquares);

        // 6. TEXT BLOCK
        System.out.println("\n6. TEXT BLOCK");
        String textBlock = """
                ╔════════════════════════════╗
                ║   MODERN JAVA FEATURES     ║
                ║        DEMO COMPLETE       ║
                ╚════════════════════════════╝
                """;
        System.out.println(textBlock);
    }
}