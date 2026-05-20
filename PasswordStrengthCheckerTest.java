package com.mrhays.security.passwordchecker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordStrengthCheckerTest {
    private final PasswordStrengthChecker checker = new PasswordStrengthChecker();

    @Test
    void shouldReturnWeakForEmptyPassword() {
        PasswordAnalysis analysis = checker.analyze("");

        assertEquals(PasswordRating.WEAK, analysis.getRating());
        assertEquals(0, analysis.getScore());
    }

    @Test
    void shouldReturnWeakForCommonPassword() {
        PasswordAnalysis analysis = checker.analyze("password123");

        assertEquals(PasswordRating.WEAK, analysis.getRating());
        assertTrue(analysis.getSuggestions().stream()
                .anyMatch(suggestion -> suggestion.contains("Avoid common passwords")));
    }

    @Test
    void shouldReturnStrongForComplexPassword() {
        PasswordAnalysis analysis = checker.analyze("Str0ng!Pass2026");

        assertEquals(PasswordRating.STRONG, analysis.getRating());
        assertTrue(analysis.getScore() >= 80);
    }

    @Test
    void shouldSuggestSymbolsWhenMissing() {
        PasswordAnalysis analysis = checker.analyze("StrongPass2026");

        assertTrue(analysis.getSuggestions().stream()
                .anyMatch(suggestion -> suggestion.contains("Add symbols")));
    }
}
