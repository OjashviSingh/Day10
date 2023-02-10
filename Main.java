import java.util.LinkedList;

class Card {
    int rank;
    String suit;

    Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "(" + this.rank + ", " + this.suit + ")";
    }
}

class Deck {
    LinkedList<Card> cards;

    Deck() {
        cards = new LinkedList<>();
    }

    void addCard(Card card) {
        cards.addLast(card);
    }

    void sortByRank() {
        cards.sort((a, b) -> a.rank - b.rank);
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}

class Player {
    String name;
    Deck deck;

    Player(String name) {
        this.name = name;
        this.deck = new Deck();
    }

    @Override
    public String toString() {
        return "Player " + name + " has cards: " + deck.toString();
    }
}

class Game {
    LinkedList<Player> players;

    Game() {
        players = new LinkedList<>();
    }

    void addPlayer(Player player) {
        players.addLast(player);
    }

    void distributeCards(Deck deck) {
        for (int i = 0; i < deck.cards.size(); i++) {
            Player player = players.getFirst();
            player.deck.addCard(deck.cards.get(i));
            players.removeFirst();
            players.addLast(player);
        }
    }

    void printPlayers() {
        for (Player player : players) {
            System.out.println(player);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.addCard(new Card(2, "Spades"));
        deck.addCard(new Card(3, "Hearts"));
        deck.addCard(new Card(5, "Diamonds"));
        deck.addCard(new Card(1, "Clubs"));
        deck.addCard(new Card(4, "Spades"));
        deck.sortByRank();

        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.distributeCards(deck);
        game.printPlayers();
    }
}
