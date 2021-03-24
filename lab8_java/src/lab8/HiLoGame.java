/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lab8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Masim
 */
public class HiLoGame extends JFrame implements ActionListener {

    public static final int WINWIDTH = 500;
    public static final int WINHEIGHT = 500;
    public static final String gameOverPath ="images/game-over.png";


    private Deck deck;  // i trapoula    

    private JButton startButton;
    private JButton exitButton;
    private JButton showButton;
    private JTextArea scoreArea;
    
    private JPanel controlPanel;
    private JPanel infoPanel;
    private JPanel gamePanel;
    private JPanel playPanel;

    private JLabel cardTop;

    private boolean gameStarted;


    @SuppressWarnings("LeakingThisInConstructor")
    public HiLoGame() {


        deck = new Deck();
        gameStarted = false;

        setSize(WINWIDTH, WINHEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        /* create left panel with start button and score area */
        controlPanel = new JPanel();
        controlPanel.setBackground(Color.RED);
        controlPanel.setLayout(new GridLayout(2,1));
        startButton = new JButton("Start");
        startButton.addActionListener(this);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        
        
        controlPanel.add(startButton);
        controlPanel.add(exitButton);
        this.add(controlPanel, BorderLayout.WEST);

        /* create top panel with  score area */
        infoPanel = new JPanel();
        infoPanel.setBackground(Color.RED);
        infoPanel.setLayout(new FlowLayout());

        scoreArea = new JTextArea("SCORE: ");
        scoreArea.setEditable(false);
        scoreArea.setBackground(Color.yellow);

        infoPanel.add(scoreArea);
        this.add(infoPanel, BorderLayout.NORTH);

        /* create middle panel with deck */
        gamePanel = new JPanel();
        gamePanel.setBackground(Color.green);
        cardTop = new JLabel();
        if ( deck!= null)
            cardTop.setIcon(deck.getTopImage());
        gamePanel.add(cardTop);
        this.add(gamePanel, BorderLayout.CENTER);

        // TODO: Prostheste ena neo panel sti deksia pleura tou parathurou.
        // To panel prepei na periexei to koumpi "Show Card" to opoio leitourgei
        // opws perigrafetai stin ekfwnisi.
        playPanel = new JPanel();
        playPanel.setBackground(Color.yellow);
        playPanel.setLayout(new FlowLayout());
        showButton = new JButton("Show Card");
        showButton.addActionListener(this);
        playPanel.add(showButton);
        this.add(playPanel, BorderLayout.EAST);
        
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (command.equals("Start")) {
            deck.shuffle();
            try {
                deck.removeTopCard();
            }
            catch (CardException ex) {
                return;
            }
            cardTop.setIcon(deck.getTopImage());
            gameStarted = true;
        }
        else if (command.equals("Exit")) {
            System.exit(0);
        }
        // TODO: Prostheste kwdika pou na xeirizetai to click sto koumpi "Show Card"
        else if (gameStarted && command.equals("Show Card")) {
            try {
                deck.removeTopCard();
            } catch (CardException ex) {
                return;
            }
            cardTop.setIcon(deck.getTopImage());
        }
    }


    // TODO: Ylopoiiste tin checkGuess opws perigrafetai stin ekfwnisi.
    private boolean checkGuess(Card currentCard, Card nextCard, String action) {
        if (action.equals("Higher") && nextCard.compareTo(currentCard) > 0 )
            return true;
        if (action.equals("Lower") && nextCard.compareTo(currentCard) < 0 )
            return true;
        if (action.equals("Equal") && nextCard.compareTo(currentCard) == 0 )
            return true;
        return false;
    }



}
