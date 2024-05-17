package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        StringBuilder currentLine = new StringBuilder();

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("next")) {
                lines.add(currentLine.toString());
                currentLine.setLength(0);
            } else if (input.equalsIgnoreCase("end")) {
                if (currentLine.length() > 0) {
                    lines.add(currentLine.toString());
                }
                break;
            } else {
                if (currentLine.length() > 0) {
                    currentLine.append(" ");
                }
                currentLine.append(input);
            }
        }

        scanner.close();

        try (FileWriter writer = new FileWriter("output.csv")) {
            for (String line : lines) {
                writer.append(line).append(",\n");
            }
            System.out.println("CSV file created: output.csv");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the CSV file.");
            e.printStackTrace();
        }
    }
}