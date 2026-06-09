package edu.norcocollege.cis18b.week2.demo;

import java.util.List;

/**
 * This class demonstrates basic Java language features:
 * - Variable declarations and types
 * - Control flow (if, switch, loops)
 * - Methods and parameters
 * - Basic OOP concepts (classes, objects, inheritance)
 */
public class LanguageBasicsReview {

    // Custom exception class
    static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }
    
    // Standard instance method
    public void instanceMethod() {
        System.out.println("  Instance method called");
    }
    
    // Static method
    public static void staticMethod() {
        System.out.println("  Static method called");
    }
    
    // Overloaded method - version 1
    public void show(String message) {
        System.out.println("  Show (1 param): " + message);
    }
    
    // Overloaded method - version 2
    public void show(String message, int times) {
        System.out.print("  Show (2 params): ");
        for (int i = 0; i < times; i++) {
            System.out.print(message + " ");
        }
        System.out.println();
    }
    
    // Inner class for OOP demonstration
    class Animal {
        private String name;
        public Animal(String name) { this.name = name; }
        public String getName() { return name; }
        public void makeSound() { System.out.println("  " + name + " makes a sound"); }
    }
    
    // Dog extends Animal - demonstrates inheritance
    class Dog extends Animal {
        public Dog(String name) { super(name); }
        @Override
        public void makeSound() { System.out.println("  " + getName() + " barks: Woof!"); }
    }

    public void demonstrate() {
        System.out.println("=== LANGUAGE BASICS REVIEW ===\n");
        
        // 1. VARIABLE DECLARATIONS AND TYPES
        System.out.println("1. Variable Declarations and Types:");
        
        // Primitive types
        int age = 25;
        double price = 19.99;
        boolean isActive = true;
        char grade = 'A';
        
        // Reference type
        String name = "Java Student";
        
        // var (type inference)
        var city = "Riverside";
        var score = 95;
        
        // Array
        int[] numbers = {10, 20, 30};
        
        // List using List.of()
        List<String> fruits = List.of("Apple", "Banana", "Orange");
        
        System.out.println("  int: " + age);
        System.out.println("  double: $" + price);
        System.out.println("  boolean: " + isActive);
        System.out.println("  char: " + grade);
        System.out.println("  String: " + name);
        System.out.println("  var: " + city + ", " + score);
        System.out.println("  array: " + numbers[0]);
        System.out.println("  List.of(): " + fruits);
        
        // 2. CONTROL FLOW
        System.out.println("\n2. Control Flow:");
        
        // if-else
        int testScore = 85;
        if (testScore >= 90) System.out.println("  Grade: A");
        else if (testScore >= 80) System.out.println("  Grade: B");
        else System.out.println("  Grade: C or lower");
        
        // for loop
        System.out.print("  For loop: ");
        for (int i = 1; i <= 3; i++) System.out.print(i + " ");
        System.out.println();
        
        // while loop
        System.out.print("  While loop: ");
        int count = 3;
        while (count > 0) System.out.print(count-- + " ");
        System.out.println("Go!");
        
        // Modern switch expression
        String day = "WEDNESDAY";
        String dayType = switch (day) {
            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> "Weekday";
            case "SATURDAY", "SUNDAY" -> "Weekend";
            default -> "Unknown";
        };
        System.out.println("  Switch: " + day + " is a " + dayType);
        
        // 3. METHODS AND PARAMETERS
        System.out.println("\n3. Methods and Parameters:");
        instanceMethod();
        staticMethod();
        show("Hello");
        show("Java", 3);
        
        // 4. OOP CONCEPTS
        System.out.println("\n4. Basic OOP Concepts:");
        Animal animal = new Animal("Generic");
        Dog dog = new Dog("Buddy");
        animal.makeSound();
        dog.makeSound();
        System.out.println("  Dog is Animal: " + (dog instanceof Animal));
        
        // 5. TRY/CATCH WITH CUSTOM EXCEPTION
        System.out.println("\n5. Try/Catch with Custom Exception:");
        try {
            if (age < 0) throw new InvalidInputException("Negative age");
            System.out.println("  Valid age: " + age);
        } catch (InvalidInputException e) {
            System.out.println("  Exception: " + e.getMessage());
        }
        
        System.out.println("\n=== Demo Complete ===");
    }
}