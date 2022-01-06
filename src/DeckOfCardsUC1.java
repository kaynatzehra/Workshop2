import java.util.ArrayList;

public class DeckOfCardsUC1
{

    public ArrayList<String> cardsDeck = new ArrayList<>();

    public void welcome(){
        System.out.println("Welcome to the gaming world of Deck of Cards");
    }
    public void deckOfCards()
    {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "King", "Queen", "Ace"};
        int numOfCards = suits.length * ranks.length;
        System.out.println("\nNumber of cards in the deck:" + numOfCards);
        for (String rank : ranks)
        {
            for (String suit : suits)
            {
                cardsDeck.add(rank + "--->" + suit);
            }
        }
    }

}
