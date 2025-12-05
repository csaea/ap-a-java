// lesson on accumulation and increment, decrement

class ScoreBoard {

    int playerXP = 0;
    int playerLevel = 0;

    void gainXP(int amount) {
        playerXP = playerXP + amount; // accumulation, long way of doing it.
    }

    void heal() {
        playerXP += 50; //compound addition, compound accumulation
    }

    void damage() {
        playerXP -= 10; // compound subtraction
    }

    // note you can also *=, /=, and %= */

    void levelUp() {
        playerLevel++;   //increment
    }

      void levelDown() {
        playerLevel--;    //decrement
    }

}

public class Math2 {
    public static void main(String[] args){

        ScoreBoard player1 = new ScoreBoard();
        ScoreBoard player2 = new ScoreBoard();

        player1.gainXP(100);
        player1.gainXP(200);
        player1.heal();
        player1.damage();
        player1.levelUp();
        player1.levelUp();
        player1.levelDown();

        player2.gainXP(400);
        player2.gainXP(500);
        player2.heal();
        player2.heal();
        player2.damage();
        player2.levelUp();
        player2.levelUp();
        player2.levelDown();

        System.out.println("Player 1 XP: " + player1.playerXP);
        System.out.println("Player 1 Level: " + player1.playerLevel);

        System.out.println("Player 2 XP: " + player2.playerXP);
        System.out.println("Player 2 Level: " + player2.playerLevel);

    }
}
