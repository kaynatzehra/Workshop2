import java.util.Scanner;

public class DeckOfCardsMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of players");
        int numOfPlayers = sc.nextInt();
        DeckOfCards deckOfCard = new DeckOfCards();
        deckOfCard.shuffleDeckOfCards();
        deckOfCard.setupDeckOfCards();
        deckOfCard.addPlayer(numOfPlayers);
        deckOfCard.orderPlayerTurn(numOfPlayers);
        deckOfCard.distributeCards();
        deckOfCard.displayPlayerCard();
        deckOfCard.displayCardSortByRank();
        sc.close();
    }
}