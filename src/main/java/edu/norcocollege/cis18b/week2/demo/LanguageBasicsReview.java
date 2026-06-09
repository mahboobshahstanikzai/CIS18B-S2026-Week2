package edu.norcocollege.cis18b.week2.demo;

import java.util.List;

/**
 * This class demonstrates basic Java language features.
 * Includes: instance methods, static methods, overloaded methods,
 * List.of(), try/catch, custom exception, modern switch expression, and var.
 */
public class LanguageBasicsReview {

    // Custom exception class
    static class InvalidValueException extends Exception {
        public InvalidValueException(String message) {
            super(message);
        }
    }

    // Standard instance method
    public void printGreeting(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // Static method
    public static int addNumbers(int a, int b) {
        return a + b;
    }

    // Overloaded method (different parameter types)
    public static int addNumbers(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method (different parameter count)
    public static double addNumbers(double a, double b) {
        return a + b;
    }

    // Method demonstrating modern switch expression
    public String getDayType(String day) {
        // Modern switch expression with arrow syntax
        return switch (day.toLowerCase()) {
            case "monday", "tuesday", "wednesday", "thursday", "friday" -> "Weekday";
            case "saturday", "sunday" -> "Weekend";
            default -> "Invalid day";
        };
    }

    // Method demonstrating try/catch
    public int divideWithTryCatch(int numerator, int denominator) {
        try {
            return numerator / denominator;
        } catch (ArithmeticException e) {
            System.out.println("Caught exception: " + e.getMessage());
            return 0;
        }
    }

    // Method that throws custom exception
    public void validateAge(int age) throws InvalidValueException {
        if (age < 0 || age > 150) {
            throw new InvalidValueException("Age must be between 0 and 150");
        }
        System.out.println("Valid age: " + age);
    }

    // Main demonstration method
    public void demonstrate() {
        System.out.println("=== Language Basics Review Demo ===");
        
        // Using var for type inference
        var message = "This is a message stored using 'var'";
        System.out.println(message);
        
        // Demonstrate instance method
        printGreeting("Java Student");
        
        // Demonstrate static methods and overloading
        var sum1 = LanguageBasicsReview.addNumbers(5, 10);
        var sum2 = LanguageBasicsReview.addNumbers(5, 10, 15);
        var sum3 = LanguageBasicsReview.addNumbers(3.5, 2.5);
        System.out.println("Sum of 5+10: " + sum1);
        System.out.println("Sum of 5+10+15: " + sum2);
        System.out.println("Sum of 3.5+2.5: " + sum3);
        
        // Demonstrate List.of() (immutable list)
        var fruits = List.of("Apple", "Banana", "Orange", "Mango");
        System.out.println("Fruits list: " + fruits);
        System.out.println("Number of fruits: " + fruits.size());
        
        // Demonstrate try/catch
        var divisionResult = divideWithTryCatch(10, 0);
        System.out.println("Division result (10/0): " + divisionResult);
        divisionResult = divideWithTryCatch(10, 2);
        System.out.println("Division result (10/2): " + divisionResult);
        
        // Demonstrate modern switch expression
        var dayType1 = getDayType("Monday");
        var dayType2 = getDayType("Saturday");
        var dayType3 = getDayType("Invalid");
        System.out.println("Monday is a: " + dayType1);
        System.out.println("Saturday is a: " + dayType2);
        System.out.println("Invalid is: " + dayType3);
        
        // Demonstrate custom exception
        try {
            validateAge(25);
            validateAge(-5);  // This will throw exception
        } catch (InvalidValueException e) {
            System.out.println("Caught custom exception: " + e.getMessage());
        }
        
        System.out.println("=== End of Language Basics Demo ===\n");
    }
}