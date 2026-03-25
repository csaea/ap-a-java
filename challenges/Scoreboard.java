//FRQ practice #2 from https://apcentral.collegeboard.org/media/pdf/ap24-frq-comp-sci-a.pdf

// Sample FRQs from the 2024 AP CS A.

// Example solution for FRQ #2 

public class Scoreboard {

// ATTRIBUTES
    private String team1Name;
    private String team2Name;
    private int team1Score;
    private int team2Score;
    private boolean isTeam1Active; // isTeam1Active could also be solved as an int (0 or 1) or String of the current team name that is active.

// CONSTRUCTOR
// sample call to constructor: Scoreboard game = new Scoreboard("Red", "Blue");
    public Scoreboard(String team1, String team2) {
        this.team1Name = team1;
        this.team2Name = team2;
	    //teamScores by default are 0 so we don't need to add them to constructor
	    // boolean defaults to false, so we must set it true here (or above, when we declared the attribute)
        this.isTeam1Active = true;
    }

//method
// game.recordPlay(1); add point to active team
// game.recordPlay(0); toggle active team
    public void recordPlay(int points) {
        if (points > 0) {
            if (isTeam1Active) {
                team1Score += points;
            } else {
                team2Score += points;
            }
        } else {
            isTeam1Active = !isTeam1Active;
        }
    }

// getter method
    public String getScore() {
	 String activeName;
	 if (isTeam1Active) {
		activeName = team1Name;
	 } else {
		activeName = team2Name;
	 }
	 // ternary operator
        // String activeName = isTeam1Active ? team1Name : team2Name;
        return team1Score + "-" + team2Score + "-" + activeName;
    }
}


// Alternative SOlution: using arrays


public class Scoreboard {
    private String[] teamNames;
    private int[] scores;
    private int activeTeamIndex;  

    public Scoreboard(String team1, String team2) {
        this.teamNames = new String[]{team1, team2};
        this.scores = new int[]{0, 0};
        this.activeTeamIndex = 0;
    }

    public void recordPlay(int points) {
        if (points > 0) {
            scores[activeTeamIndex] += points;
        } else {
            activeTeamIndex = 1 - activeTeamIndex;
        }
    }

    public String getScore() {
        return scores[0] + "-" + scores[1] + "-" + teamNames[activeTeamIndex];
    }
}


