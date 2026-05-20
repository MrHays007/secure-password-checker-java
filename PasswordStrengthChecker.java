package com.mrhays.security.passwordchecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PasswordStrengthChecker {
    private static final int MINIMUM_LENGTH = 8;
    private static final int STRONG_LENGTH = 12;

    private static final Set<String> COMMON_PASSWORDS = Set.of(
            "password",
            "password123",
            "123456",
            "12345678",
            "qwerty",
            "admin",
            "letmein",
            "welcome",
            "iloveyou",
            "football"
    );

    public PasswordAnalysis analyze(String password) {
        if (password == null || password.isBlank()) {
            return new PasswordAnalysis(
                    PasswordRating.WEAK,
                    0,
                    List.of(),
                    List.of("Password cannot be empty.")
            );
        }

        int score = 0;
        List<String> positiveChecks = new ArrayList<>();
        List<String> suggestions = new ArrayList<>();

        String normalizedPassword = password.toLowerCase();

        if (COMMON_PASSWORDS.contains(normalizedPassword)) {
            suggestions.add("Avoid common passwords that attackers can guess easily.");
        } else {
            score += 10;
            positiveChecks.add("Not found in the small common-password list");
        }

        if (password.length() >= STRONG_LENGTH) {
            score += 30;
            positiveChecks.add("Good length");
        } else if (password.length() >= MINIMUM_LENGTH) {
            score += 15;
            positiveChecks.add("Meets minimum length");
            suggestions.add("Use at least 12 characters for stronger protection.");
        } else {
            suggestions.add("Use at least 8 characters. Preferably use 12 or more.");
        }

        if (containsUppercase(password)) {
            score += 15;
            positiveChecks.add("Contains uppercase letters");
        } else {
            suggestions.add("Add uppercase letters.");
        }

        if (containsLowercase(password)) {
            score += 15;
            positiveChecks.add("Contains lowercase letters");
        } else {
            suggestions.add("Add lowercase letters.");
        }

        if (containsDigit(password)) {
            score += 15;
            positiveChecks.add("Contains numbers");
        } else {
            suggestions.add("Add numbers.");
        }

        if (containsSymbol(password)) {
            score += 15;
            positiveChecks.add("Contains symbols");
        } else {
            suggestions.add("Add symbols such as !, @, #, $, %, or &.");
        }

        PasswordRating rating = determineRating(score);

        if (suggestions.isEmpty()) {
            suggestions.add("No major issues found. Keep using unique passwords for every account.");
        }

        return new PasswordAnalysis(rating, Math.min(score, 100), positiveChecks, suggestions);
    }

    private PasswordRating determineRating(int score) {
        if (score >= 80) {
            return PasswordRating.STRONG;
        }

        if (score >= 50) {
            return PasswordRating.MODERATE;
        }

        return PasswordRating.WEAK;
    }

    private boolean containsUppercase(String input) {
        return input.chars().anyMatch(Character::isUpperCase);
    }

    private boolean containsLowercase(String input) {
        return input.chars().anyMatch(Character::isLowerCase);
    }

    private boolean containsDigit(String input) {
        return input.chars().anyMatch(Character::isDigit);
    }

    private boolean containsSymbol(String input) {
        return input.chars().anyMatch(character -> !Character.isLetterOrDigit(character));
    }
}
