
import java.io.*;
import java.util.*;

public class task1 {

    static final String FILE_NAME = "codtech_file.txt";

    // Method to write content to a file
    public static void writeToFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read content from a file
    public static void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\nReading file contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println(">> " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to modify file content by appending additional data
    public static void appendToFile(String newContent) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.newLine();  // Adds a new line before appending
            writer.write(newContent);
            System.out.println("File modified successfully (content appended).");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Step 1: Write
            System.out.println("Enter text to write to file:");
            String initialContent = scanner.nextLine();
            writeToFile(initialContent);
            // Step 2: Read
            readFromFile();
            // Step 3: Append
            System.out.println("\nEnter text to append to file:");
            String newContent = scanner.nextLine();
            appendToFile(newContent);
            // Step 4: Read again
            readFromFile();
        }
    }
}
