package com.bengodwinweb;

public class Main {

    public static void main(String[] args) {
	    boolean gameOver = true;
	    int score = 800;
	    int levelCompleted = 5;
	    int bonus = 100;

        System.out.println(calculateScore(gameOver, score, levelCompleted, bonus));

	    score = 10000;
	    levelCompleted = 8;
	    bonus = 200;

        System.out.println(calculateScore(gameOver, score, levelCompleted, bonus));

        String playerName = "Ben";
        int playerScore = 1500;
        System.out.println(displayHighScorePosition(playerName, calculateHighScorePosition(playerScore)));

        playerName = "Neb";
        playerScore = 900;
        System.out.println(displayHighScorePosition(playerName, calculateHighScorePosition(playerScore)));

        playerName = "Deerf";
        playerScore = 400;
        System.out.println(displayHighScorePosition(playerName, calculateHighScorePosition(playerScore)));

        playerName = "Splorn";
        playerScore = 50;
        System.out.println(displayHighScorePosition(playerName, calculateHighScorePosition(playerScore)));
    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
        int finalScore = -1;
        if (gameOver) {
            finalScore = score + (levelCompleted * bonus);
        }
        return finalScore;
    }

    public static String displayHighScorePosition(String playerName, int playerPosition) {
        return playerName + " managed to get into position " + playerPosition;
    }

    public static int calculateHighScorePosition(int playerScore) {
        int position = 4;

        if (playerScore >= 1000) {
            position = 1;
        } else if (playerScore >= 500) {
            position = 2;
        } else if (playerScore >= 100) {
            position = 3;
        }

        return position;
    }
}
