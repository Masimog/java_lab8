/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lab8;

/**
 *
 * @Masim
 */
public class CardException extends Exception {

    public CardException() {
        super("Error in Card usage");
    }

    public CardException(String msg) {
        super(msg);
    }

}
