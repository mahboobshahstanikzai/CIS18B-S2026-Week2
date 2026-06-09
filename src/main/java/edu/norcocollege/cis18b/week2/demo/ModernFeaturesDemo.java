package edu.norcocollege.cis18b.week2.demo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * This class demonstrates modern Java features (Java 17+).
 * Includes: record type, pattern matching with instanceof,
 * switch expression, Optional, Stream operation, and text block.
 */
public class ModernFeaturesDemo {

    // Record type (Java 14+)
    record Person(String name, int age, String city) {}
    
    // Another record for demonstration
    record Product(String id, String name, double price, String category) {}

    // Method demonstrating pattern matching with instanceof (Java 16+)
    public static String getObjectTypeInfo(Object obj) {
        // Pattern matching for instanceof (no need for explicit cast)
        if (obj instanceof String s) {
            return "String of length: " + s.length();
        } else if (obj instanceof Integer i) {
            return "Integer with value: " + i;
        } else if (obj instanceof Person p) {
            return "Person named: " + p.name() + ", age " + p.age();
        } else if (obj instanceof List<?> list) {
            return "List with " + list.size() + " elements";
        }
        return "Unknown type: " + obj.getClass().getSimpleName();
    }

    // Method demonstrating modern switch expression (Java 14+)
    public static String getPriorityLevel(String severity) {
        // Modern switch expression - no fallthrough, returns value
        return switch (severity.toUpperCase()) {
            case "CRITICAL" -> "Priority 1 - Immediate Action Required";
            case "HIGH" -> "Priority 2 - Urgent";
            case "MEDIUM" -> "Priority 3 - Normal";
            case "LOW" -> "Priority 4 - Low";
            default -> "Priority 5 - Unknown";
        };
    }

    // Method demonstrating Optional usage (Java 8+)
    public static Optional<Person> findPersonByName(List<Person> people, String name) {
        return people.stream()
            .filter(p -> p.name().equalsIgnoreCase(name))
            .findFirst();
    }

    // Method demonstrating Stream operation
    public static List<String> getExpensiveProductNames(List<Product> products, double minPrice) {
        return products.stream()
            .filter(p -> p.price() > minPrice)           // Filter expensive products
            .map(Product::name)                          // Extract names
            .sorted()                                    // Sort alphabetically
            .collect(Collectors.toList());               // Collect to list
    }

    public void demonstrate() {
        System.out.println("=== Modern Features Demo ===");
        
        // 1. Demonstrate Record Type
        System.out.println("\n--- 1. Record Type Demonstration ---");
        var person1 = new Person("Alice", 28, "New York");
        var person2 = new Person("Bob", 34, "Los Angeles");
        var person3 = new Person("Charlie", 22, "Chicago");
        System.out.println("Person record: " + person1);
        System.out.println("Name: " + person1.name());
        System.out.println("Age: " + person1.age());
        System.out.println("City: " + person1.city());
        
        // 2. Demonstrate Pattern Matching with instanceof
        System.out.println("\n--- 2. Pattern Matching with instanceof ---");
        System.out.println("Checking a String: " + getObjectTypeInfo("Hello World"));
        System.out.println("Checking an Integer: " + getObjectTypeInfo(42));
        System.out.println("Checking a Person: " + getObjectTypeInfo(person2));
        System.out.println("Checking a List: " + getObjectTypeInfo(List.of(1, 2, 3)));
        
        // 3. Demonstrate Switch Expression
        System.out.println("\n--- 3. Switch Expression ---");
        System.out.println("CRITICAL severity -> " + getPriorityLevel("CRITICAL"));
        System.out.println("HIGH severity -> " + getPriorityLevel("HIGH"));
        System.out.println("MEDIUM severity -> " + getPriorityLevel("MEDIUM"));
        System.out.println("LOW severity -> " + getPriorityLevel("LOW"));
        
        // 4. Demonstrate Optional
        System.out.println("\n--- 4. Optional Demonstration ---");
        var people = List.of(person1, person2, person3);
        
        var foundPerson = findPersonByName(people, "Bob");
        foundPerson.ifPresentOrElse(
            p -> System.out.println("Found person: " + p.name() + " from " + p.city()),
            () -> System.out.println("Person not found")
        );
        
        var notFound = findPersonByName(people, "David");
        System.out.println("Search for David: " + notFound.orElse(new Person("Unknown", 0, "Unknown")));
        
        // Demonstrate Optional methods
        Optional<String> optionalName = Optional.of("Java User");
        System.out.println("Optional value: " + optionalName.orElse("Default"));
        
        // 5. Demonstrate Stream Operation
        System.out.println("\n--- 5. Stream Operation ---");
        var products = List.of(
            new Product("P001", "Laptop", 999.99, "Electronics"),
            new Product("P002", "Mouse", 29.99, "Electronics"),
            new Product("P003", "Monitor", 299.99, "Electronics"),
            new Product("P004", "Keyboard", 89.99, "Electronics"),
            new Product("P005", "Desk", 499.99, "Furniture")
        );
        
        var expensiveProducts = getExpensiveProductNames(products, 100.00);
        System.out.println("Products over $100: " + expensiveProducts);
        
        // Additional stream operations
        var averagePrice = products.stream()
            .mapToDouble(Product::price)
            .average();
        System.out.println("Average product price: $" + averagePrice.orElse(0.0));
        
        // 6. Demonstrate Text Block (Java 13/14+)
        System.out.println("\n--- 6. Text Block Demonstration ---");
        var textBlock = """
            ╔══════════════════════════════════════╗
            ║     MODERN JAVA FEATURES SUMMARY     ║
            ╠══════════════════════════════════════╣
            ║  ✓ Records (compact data carriers)   ║
            ║  ✓ Pattern matching with instanceof  ║
            ║  ✓ Switch expressions                ║
            ║  ✓ Optional (safe null handling)     ║
            ║  ✓ Stream API (functional operations)║
            ║  ✓ Text blocks (multi-line strings)  ║
            ╚══════════════════════════════════════╝
            """;
        System.out.println(textBlock);
        
        System.out.println("\n=== End of Modern Features Demo ===\n");
    }
}