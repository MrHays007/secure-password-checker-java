package com.mrhays.security.passwordchecker;

import java.io.Console;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        PasswordStrengthChecker checker = new PasswordStrengthChecker();

        printHeader();
        String password = readPassword();
        PasswordAnalysis analysis = checker.analyze(password);
        printAnalysis(analysis);
    }

    private static void printHeader() {
        System.out.println("====================================");
        System.out.println(" Secure Password Checker - Java");
        System.out.println("====================================");
    }

    private static String readPassword() {
        Console console = System.console();

        if (console != null) {
            char[] passwordChars = console.readPassword("Enter a password to analyze: ");
            return new String(passwordChars);
        }

        // Some IDEs do not support Console.readPassword().
        // This fallback is convenient for learning, but it cannot hide terminal input.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password to analyze: ");
        return scanner.nextLine();
    }

    private static void printAnalysis(PasswordAnalysis analysis) {
        System.out.println();
        System.out.println("Rating: " + analysis.getRating());
        System.out.println("Score: " + analysis.getScore() + "/100");

        System.out.println();
        System.out.println("Positive checks:");
        if (analysis.getPositiveChecks().isEmpty()) {
            System.out.println("- No positive checks yet");
        } else {
            analysis.getPositiveChecks().forEach(check -> System.out.println("- " + check));
        }

        System.out.println();
        System.out.println("Suggestions:");
        analysis.getSuggestions().forEach(suggestion -> System.out.println("- " + suggestion));
    }
}
