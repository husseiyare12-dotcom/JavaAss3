
import java.util.Scanner;

class InvalidRegistrationException extends Exception {
    public InvalidRegistrationException(String message) {
        super(message);
    }
}

public class ExamRegistration {

    public static void validateRegistration(String studentId, int age, double mark, int subjects)
            throws InvalidRegistrationException {

        if (studentId.trim().isEmpty()) {
            throw new InvalidRegistrationException("Student ID cannot be empty.");
        }

        if (age < 18) {
            throw new InvalidRegistrationException("Age must be at least 18.");
        }

        if (mark < 0 || mark > 100) {
            throw new InvalidRegistrationException("Exam mark must be between 0 and 100.");
        }

        if (subjects < 1 || subjects > 5) {
            throw new InvalidRegistrationException("Maximum allowed subjects is 5.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("===== EXAM REGISTRATION SYSTEM =====");

            System.out.print("Enter Student ID: ");
            String studentId = input.nextLine();

            System.out.print("Enter Student Name: ");
            String name = input.nextLine();

            System.out.print("Enter Age: ");
            int age = Integer.parseInt(input.nextLine());

            System.out.print("Enter Exam Mark: ");
            double mark = Double.parseDouble(input.nextLine());

            System.out.print("Enter Number of Subjects: ");
            int subjects = Integer.parseInt(input.nextLine());

            validateRegistration(studentId, age, mark, subjects);

            System.out.println("\nRegistration Successful!");
            System.out.println("Student: " + name);
            System.out.println("Registered Subjects: " + subjects);

        } catch (InvalidRegistrationException e) {
            System.out.println("\nRegistration Failed!");
            System.out.println("Error: " + e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("\nRegistration Failed!");
            System.out.println("Error: Please enter valid numeric values.");

        } finally {
            System.out.println("\nRegistration attempt completed.");
            input.close();
        }
    }
}
