import java.util.ArrayList;
import java.util.Scanner;

public class DeckOfCards {

    public static final Scanner scanner = new Scanner(System.in);
    public ArrayList<String> cardsDeck = new ArrayList<>();


    public void deckOfCards() {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "King", "Queen", "Ace"};
        int numOfCards = suits.length * ranks.length;
        System.out.println("\nNumber of cards in the deck is : " + numOfCards);
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                cardsDeck.add(ranks[i] + "--" + suits[j]);
            }
        }
        toDisplay(cardsDeck);
    }
    public static void toDisplay(ArrayList<String> cardsDeck) {
        System.out.println("\nCards in Deck:");
        for (String element : cardsDeck) {
            System.out.println(element);
        }
        System.out.println();
    }

    public void players() {
        System.out.print("\nEnter number of players minimum 2 , maximum 4 : ");
        int player = scanner.nextInt();
        if (player >= 2 && player <= 4) {
            System.out.println("\n" + player + " players will play the game");
        } else {
            System.out.println("Please enter number of players in the Range");
            this.players();
            scanner.close();
        }
    }
}
