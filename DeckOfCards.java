import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeckOfCards {
    List<String> deck;
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    public DeckOfCards() {
        deck = new ArrayList<String>();
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + " of " + suit);
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck, new Random());
    }

    public void distributeCards() {
        String[][] playerCards = new String[4][9];
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 9; j++) {
                playerCards[i][j] = deck.get(index);
                index++;
            }
        }

        System.out.println("Cards distributed to players:");
        for (int i = 0; i < 4; i++) {
            System.out.println("Player " + (i + 1) + ": ");
            for (int j = 0; j < 9; j++) {
                System.out.println(playerCards[i][j]);
            }
            System.out.println();
        }
    }
}
