package lab8;

import javax.swing.ImageIcon;

/**
 *
 * @author Masim
 */
public class Deck {
    
    public static final int SIZE=52;

    private Card[] deck;
    private int topCard;
    private java.util.Random rand;

    /**
     * Creates a new deck of cards.
     * The deck is not shuffled.
     */
    public Deck() {
        deck = new Card[SIZE];
        topCard = -1; /* index of revealed card at the top. -1 means no cards are revealed yet */
        for (int i=0; i<SIZE; i++) {
            deck[i] = new Card(i%4, i%13+1);
        }
        rand = new java.util.Random();
    }

    /**
     * Shuffles the deck.
     */
    public void shuffle() {
        
        for (int i=0; i<SIZE; i++) {
            int pos1 = rand.nextInt(SIZE);
            int pos2 = rand.nextInt(SIZE);
            /* swap */
            Card temp = deck[pos1];
            deck[pos1] = deck[pos2];
            deck[pos2] = temp;
        }
        topCard = -1; // start over
    }

    /**
     * Pulls the top card from the deck, so that the next one becomes visible.
     * 
     */

    // TODO: Xeiristite tin periptwsi pou den yparxoun alla trapouloxarta stin trapoula.
    public void removeTopCard() throws CardException  {
        ++topCard;
        if (topCard >= SIZE) {
            throw new CardException("No more cards");
        }
    }

    /**
     * Returns the card that is currently revealed at the top of the deck.
     * @return the card at the top of the deck.
     */
    // TODO: Xeiristite tin periptwsi pou den exoun akomi emfanistei trapouloxarta.
    public Card getTopCard() throws CardException {
        
        // deite edw ena paradeigma xeirismou enos exception me petagma enos allou.
        try {
            return deck[topCard];
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            throw new CardException();
        }
    }



    /**
     * Returns the image for the top revealed card. If no cards have been revealed
     * yet, it returns the image on the back of the card.
     * 
     * @return the top card's image
     */
    public ImageIcon getTopImage() {
        if (topCard == -1) {
            return Card.getBackImage();
        }
        else {
            return deck[topCard].getFrontImage();
        }

    }

}
