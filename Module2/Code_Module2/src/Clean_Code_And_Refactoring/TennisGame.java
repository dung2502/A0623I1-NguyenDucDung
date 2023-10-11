package Clean_Code_And_Refactoring;

public class TennisGame {

    public static String getScore(int scorePlayer1, int scorePlayer2) {
        if (scorePlayer1 == scorePlayer2) {
            return getEqualScore(scorePlayer1);
        } else if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            return getAdvantageOrWin(scorePlayer1, scorePlayer2);
        } else {
            return getScoreDescription(scorePlayer1) + "-" + getScoreDescription(scorePlayer2);
        }
    }

    private static String getEqualScore(int score) {
        if (score < 3) {
            return getScoreDescription(score) + "-All";
        } else {
            return "Deuce";
        }
    }

    private static String getAdvantageOrWin(int scorePlayer1, int scorePlayer2) {
        int minusResult = scorePlayer1 - scorePlayer2;
        if (Math.abs(minusResult) == 1) {
            return "Advantage " + (minusResult == 1 ? "player1" : "player2");
        } else {
            return "Win for " + (minusResult >= 2 ? "player1" : "player2");
        }
    }

    private static String getScoreDescription(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                throw new IllegalArgumentException("Invalid score: " + score);
        }
    }
}
