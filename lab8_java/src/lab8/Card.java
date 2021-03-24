/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lab8;

import javax.swing.ImageIcon;

// TODO: Prostheste kwdika wste na mporei na ginei sygkrisi duo trapouloxartwn
// me basi tin aksia tous opws auti upologizetai apo to getValue
public class Card implements Comparable<Card>  {

    public static final String [] Suits={"clubs", "diamonds", "hearts", "spades"};
    private static String backImage="images/back-blue-150-1.png";
    
    private int rank;
    private int suit;

    public Card(int suit, int rank) {
        this.rank = rank;
        this.suit = suit;
        
    }

    public int getValue() {
        return (rank>10)? 10: rank;
    }

    public ImageIcon getFrontImage() {
        return new ImageIcon("images/"+ Suits[suit]+"-"+rank+"-150.png");
    }

    public static ImageIcon getBackImage() {
        return new ImageIcon(backImage);
    }

    public int compareTo(Card t) {
        return getValue() - t.getValue();
    }


}
