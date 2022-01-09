import java.util.*;
import java.util.stream.Collectors;

public class DeckOfCards {
    private static String[] suit = { "Spades", "Hearts", "Diamond", "Clubs" };
    private static String[] rank = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
    private static String[][] deckOfCards = { suit, rank };
    private static Card[] deck = new Card[52];
    private static List<Player> playerList = new ArrayList<Player>();
    private static Scanner sc = new Scanner(System.in);
    Map<String, HashMap<String, Integer>> playerCardInfo = new HashMap<String, HashMap<String, Integer>>();

    public void setupDeckOfCards() {
        int i = 0;
        for (String s : deckOfCards[0]) {
            for (String value : deckOfCards[1]) {
                deck[i++] = new Card(s, value);
            }
        }
    }


    public void addPlayer(int numberOfPlayers) {
        System.out.println("Enter players details");
        if (numberOfPlayers >= 4) {
            System.out.println("Maximum of 4 players is allowed");
        } else {
            for (int i = 0; i < numberOfPlayers; i++) {
                System.out.println("Enter first name");
                String fn = sc.nextLine();
                System.out.println("Enter second name");
                String ln = sc.nextLine();
                Player player = new Player(fn, ln);
                playerList.add(player);
                for (int j = 0; j < playerList.size(); j++) {
                    System.out.println(playerList.get(j));
                }
            }
        }
    }


    public void shuffleDeckOfCards() {
        Random rand = new Random();
        for (int i = 0; i < deckOfCards.length; i++) {
            String[] tempArray = deckOfCards[i];
            for (int j = 0; j < tempArray.length; j++) {
                // Random for remaining positions.
                int r = j + rand.nextInt(tempArray.length - j);
                // swapping the elements
                String temp = tempArray[r];
                tempArray[r] = tempArray[j];
                tempArray[j] = temp;
            }
            deckOfCards[i] = tempArray;
        }
    }


    public void distributeCards() {
        playerList.stream().sorted(Comparator.comparingInt(Player::getPlayerTurn)).collect(Collectors.toList());
        for (int p = 0; p < playerList.size(); p++) {
            int count = 0;
            int cardIndex = p;
            Card[] cardSet = new Card[9];
            while (count < 9) {
                Card card = deck[cardIndex];
                cardSet[count] = card;
                cardIndex += 5;
                count++;
            }
            playerList.get(p).setCard(cardSet);
        }
    }


    public void printDeck() {
        for (int i = 0; i < deck.length; i++) {
            System.out.println(deck[i]);
        }
    }

    public void orderPlayerTurn(int numberOfPlayers) {
        System.out.println("Enter players order");
        for (int i = 0; i < numberOfPlayers; i++) {
            int turn = sc.nextInt();
            playerList.get(i).setPlayerTurn(turn);
        }
    }

    public void displayPlayerCard() {
        for (int i = 0; i < playerList.size(); i++) {
            HashMap<String, Integer> cardInfo = new HashMap<String, Integer>();
            Card[] cardArray = playerList.get(i).getCard();
            for (int j = 0; j < cardArray.length; j++) {
                if (cardInfo.containsKey(cardArray[j].getSuit())) {
                    Integer value = cardInfo.get(cardArray[j].getSuit());
                    cardInfo.put(cardArray[j].getSuit(), value + 1);
                } else {
                    cardInfo.put(cardArray[j].getSuit(), Integer.valueOf(1));
                }
            }
            playerCardInfo.put(playerList.get(i).getFirstname(), cardInfo);
        }
        for (Map.Entry<String, HashMap<String, Integer>> entry : playerCardInfo.entrySet())
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
    }

    public void displayCardSortByRank() {
        for (int i = 0; i < playerList.size(); i++) {
            System.out.println("Player" + (i + 1) + " cards");
            Card[] cardArray = playerList.get(i).getCard();
            Arrays.sort(cardArray, new SortbySuit());
            // Arrays.sort(cardArray, new SortbyRank());
            for (int j = 0; j < cardArray.length; j++) {
                System.out.println(cardArray[j]);
            }
            System.out.println();
        }
    }

}

class SortbySuit implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
        if (card1.getSuit() == card2.getSuit()) {
            return card1.getRank().compareTo(card2.getRank());
        }
        return card1.getSuit().compareTo(card2.getSuit());
    }
}

class SortbyRank implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
        if (card1.getRank() == card2.getRank()) {
            return card1.getSuit().compareTo(card2.getSuit());
        }
        return card1.getRank().compareTo(card2.getRank());
    }
}