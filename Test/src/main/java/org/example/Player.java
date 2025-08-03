package org.example;

public class Player {
    private int rank;
    private String username;
    private int score;

    // We don't store rank in the constructor as it's calculated dynamically
    public Player(String username, int score) {
        this.username = username;
        this.score = score;
    }

    // Getters and Setters
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Rank: %-4d | Name: %-15s | Score: %d", rank, username, score);
    }
}