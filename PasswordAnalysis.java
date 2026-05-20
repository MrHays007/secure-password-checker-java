package com.mrhays.security.passwordchecker;

import java.util.List;

public class PasswordAnalysis {
    private final PasswordRating rating;
    private final int score;
    private final List<String> positiveChecks;
    private final List<String> suggestions;

    public PasswordAnalysis(
            PasswordRating rating,
            int score,
            List<String> positiveChecks,
            List<String> suggestions
    ) {
        this.rating = rating;
        this.score = score;
        this.positiveChecks = List.copyOf(positiveChecks);
        this.suggestions = List.copyOf(suggestions);
    }

    public PasswordRating getRating() {
        return rating;
    }

    public int getScore() {
        return score;
    }

    public List<String> getPositiveChecks() {
        return positiveChecks;
    }

    public List<String> getSuggestions() {
        return suggestions;
    }
}
