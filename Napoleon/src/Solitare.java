
/*
 * Leobmcneil@gmail.com
 * Uppgift 4
	Simple Solitare Card Game in Java
	Written by Tim Budd, Oregon State University, 1996
	Edited by Leo Bergquist Mcneil 
	
	A game that takes one pile with a sequence from 6 to ace and one pile 
	that takes in the sequence from 7 to king. How to win is by implenting
	all sequences 4 times each on the piles. The other piles are just there
	to make the solitare easier. 
*/

import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// creates a new deck 
class DeckPile extends CardPile {

	Card tempCard;

	DeckPile(int x, int y, boolean isShuffled) {
		// first initialize parent
		super(x, y);

		// create a new deck
		for (int i = 0; i < 4; i++)
			for (int j = 0; j <= 12; j++)
				addCard(new Card(i, j));

		// shuffle the cards
		if (isShuffled == true) {
			Collections.shuffle(thePile);
		}
	}
}
	
// checks if a card can be added to the piles
class DiscardPile extends CardPile {

	DiscardPile(int x, int y) {
		super(x, y);
	}

	public void addCard(Card aCard) {
		if (!aCard.faceUp())
			aCard.flip();
		super.addCard(aCard);
	}
}

// represents the middlepile on the playtable
class MiddlePile extends CardPile {

	MiddlePile(int x, int y) {
		super(x, y);
	}

	static final int MAX_HIGH_CARD = 5;
	static final int MIN_LOW_CARD = 0;

	// the rules for the middlepile
	public boolean canTake(Card aCard) {
		if (isEmpty())
			return aCard.rank() == MAX_HIGH_CARD;
		Card topCard = top();
		if (topCard.rank() == MIN_LOW_CARD)
			return aCard.rank() == MAX_HIGH_CARD;

		return (aCard.rank() == topCard.rank() - 1);
	}
}

// the decks that arent based on the sixes or sevens
class RestOfCardsPile extends CardPile {

	RestOfCardsPile(int x, int y) {
		super(x, y);
	}

	// Can only take card if its empty
	public boolean canTake(Card aCard) {
		if (isEmpty())
			return true;
		return false;
	}

	/* Check if a card can be taken in the six or seven pile, if thats the case,
	   then move it. */
	public void select(int tx, int ty) {
		if (isEmpty())
			return;
		Card topCard = pop();
		if (ShowSolitare.middlePile.canTake(topCard)) {
			ShowSolitare.middlePile.addCard(topCard);
			return;
		}
		for (int i = 0; i < ShowSolitare.highSequencePile.length; i++)
			if (ShowSolitare.highSequencePile[i].canTake(topCard)) {
				ShowSolitare.highSequencePile[i].addCard(topCard);
				return;
			}
		// else let the card be in the same place
		addCard(topCard);
	}
}

// represents the parkedpile in the top
class ParkedPile extends CardPile {

	ParkedPile(int x, int y) {
		super(x, y);
	}

	// park the 6 on the parkedpile
	public boolean canTake(Card aCard) {
		if (aCard.rank() == 5 && isEmpty())
			return aCard.rank() == 5;
		else {
			return false;
		}
	}

	// Check if parkedpile can take a card
	public void select(int tx, int ty) {
		if (isEmpty())
			return;
		Card topCard = pop();
		if (ShowSolitare.middlePile.canTake(topCard)) {
			ShowSolitare.middlePile.addCard(topCard);
			return;
		}
		// else let the card stay at the same place
		addCard(topCard);
	}
}

// represents the pile where the card go in a higher sequence starting from 7
class HighSequencePile extends CardPile {

	static final int ACCEPTED_CARD = 6;

	HighSequencePile(int x, int y) {
		super(x, y);
	}

	// Check if a card can be taken
	public boolean canTake(Card aCard) {
		if (isEmpty())
			return aCard.rank() == ACCEPTED_CARD;
		Card topCard = top();
		return (aCard.rank() == topCard.rank() + 1);
	}
}

// print out the gametable and the cardsx
class ShowSolitare extends JPanel {

	static public DeckPile deckPile;
	static public DiscardPile discardPile;
	static public ParkedPile parkedPile;
	static public MiddlePile middlePile;

	static public RestOfCardsPile restOfCardsPile[];
	static public CardPile allPiles[];
	static public HighSequencePile highSequencePile[];

	static final int _x = 75;
	static final int _y = 220;
	static final int _x1 = 70;
	static final int _y1 = 50;
	static final int START_PLACE = 15;
	 int maxRounds = 2;

	private int round = 1;
	private boolean gameWon = true;
	private boolean sortedDeck = true;

	private Card selectedCard;
	private CardPile selectedCardSource;

	// add events
	public ShowSolitare() {

		init();
		setBackground(Color.WHITE);
		addMouseListener(new MouseKeeper());

		JButton restartButton = new JButton("New Game");
		restartButton.addActionListener(new RestartButtonListener());
		add("South", restartButton);

		JButton restartButtonFixedDeck = new JButton("Play with a sorted deck");
		restartButtonFixedDeck.addActionListener(new RestartButtonFixedDeckListener());
		add(restartButtonFixedDeck);

		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ExitButtonListener());
		add(exitButton);
	}

	/** create the piles and give them their position */
	public void init() {

		allPiles = new CardPile[12];
		highSequencePile = new HighSequencePile[4];
		restOfCardsPile = new RestOfCardsPile[4];

		// fill the piles and give them their position
		allPiles[0] = deckPile = new DeckPile(335, 50, !sortedDeck);
		allPiles[1] = discardPile = new DiscardPile(268, 50);

		allPiles[2] = highSequencePile[0] = new HighSequencePile(START_PLACE + (Card.width) + Card.height + _x - _x1,_y + _x);
		allPiles[3] = highSequencePile[1] = new HighSequencePile(START_PLACE + (Card.width) + Card.height + _x + _x1,_y + _x);
		allPiles[4] = highSequencePile[2] = new HighSequencePile(START_PLACE + (Card.width) + Card.height + _x - _x1,_y - _x);
		allPiles[5] = highSequencePile[3] = new HighSequencePile(START_PLACE + (Card.width) + Card.height + _x + _x1,_y - _x);

		allPiles[6] = restOfCardsPile[0] = new RestOfCardsPile(START_PLACE + (Card.width) + Card.height + _x, _y + _x1);
		allPiles[7] = restOfCardsPile[1] = new RestOfCardsPile(START_PLACE + (Card.width) + Card.height + _x - _y1, _y);
		allPiles[8] = restOfCardsPile[2] = new RestOfCardsPile(START_PLACE + (Card.width) + Card.height + _x + _y1, _y);
		allPiles[9] = restOfCardsPile[3] = new RestOfCardsPile(START_PLACE + (Card.width) + Card.height + _x, _y - _x1);

		allPiles[10] = parkedPile = new ParkedPile(_x1, _y1);
		allPiles[11] = middlePile = new MiddlePile(START_PLACE + (Card.width) + Card.height + _x, _y);
	}

	/** Check if the the card includes the koordinates and if its not empty. if its
	 * not empty, check available place the card can be put on according to the
	 * rules, and if the destination is valid, put the card down.
	 * @param tx
	 * @param ty 
	 */
	public void clickController(int tx, int ty) {
		if (selectedCard == null) {
			if (deckPile.includes(tx, ty)) {
				deckClick();
				return;
			}
			if (discardPile.includes(tx, ty)) {
				discardClick();
				return;
			}
			if (middlePile.includes(tx, ty) && !middlePile.isEmpty()) {
				middleClicked(middlePile);
				return;
			}
			if (parkedPile.includes(tx, ty) && !parkedPile.isEmpty()) {
				parkedClicked(parkedPile);
				return;
			}
			for (int i = 0; i < highSequencePile.length; i++) {
				if (highSequencePile[i].includes(tx, ty) && !highSequencePile[i].isEmpty()) {
					highSequenceClicked(highSequencePile[i]);
					return;
				}
			}
			for (int i = 0; i < ShowSolitare.restOfCardsPile.length; i++) {
				if (restOfCardsPile[i].includes(tx, ty) && !restOfCardsPile[i].isEmpty()) {
					restCardsClicked(restOfCardsPile[i]);
					return;
				}
			}
		} 
		else {
			if (middlePile.includes(tx, ty) && middlePile.canTake(selectedCard)) {
				placeSelectedCard(middlePile);
				return;
			}
			if (parkedPile.includes(tx, ty) && parkedPile.canTake(selectedCard)) {
				placeSelectedCard(parkedPile);
				return;
			}
			for (int i = 0; i < highSequencePile.length; i++) {
				if (highSequencePile[i].includes(tx, ty) && highSequencePile[i].canTake(selectedCard)) {
					placeSelectedCard(highSequencePile[i]);
					return;
				}
			}
			for (int i = 0; i < ShowSolitare.restOfCardsPile.length; i++) {
				if (restOfCardsPile[i].includes(tx, ty) && restOfCardsPile[i].canTake(selectedCard)) {
					placeSelectedCard(restOfCardsPile[i]);
					return;
				}
			}
			restoreSelectedCard();
		}
	}

	/* give user the option to click to get one more deck of cards
	 * max 2 decks per game is allowed 
	 * move card from deck to discard pile 
	 * move discard pile to deck if deck is empty */
	private void deckClick() {
		if (deckPile.isEmpty() && round != maxRounds) {
			round++;
			while (!discardPile.isEmpty()) {
				Card tempCard = discardPile.pop();
				tempCard.flip();
				deckPile.addCard(tempCard);
			}
		}
		if (deckPile.isEmpty() && round == maxRounds)
			return;
		discardPile.addCard(deckPile.pop());
	}
	private void setNewDecktoZero() {
		round = 1;
		maxRounds = 2;
	}

	// check clicks
	private void discardClick() {
		selectCard(discardPile.pop(), discardPile);
	}

	private void highSequenceClicked(CardPile crdPile) {
		selectCard(crdPile.pop(), crdPile);
	}

	private void restCardsClicked(CardPile crdPile) {
		selectCard(crdPile.pop(), crdPile);
	}

	private void middleClicked(CardPile crdPile) {
		selectCard(crdPile.pop(), crdPile);
	}

	private void parkedClicked(CardPile crdPile) {
		selectCard(crdPile.pop(), crdPile);
	}

	// select a card
	private void selectCard(Card crd, CardPile crdSource) {
		selectedCard = crd;
		selectedCardSource = crdSource;
		findValidDestantions(crd);
	}

	// check if the card can be put on the specific spot according to the rules
	private void findValidDestantions(Card crd) {
		for (int i = 0; i < allPiles.length; i++) {
			if (allPiles[i].canTake(crd)) {
				allPiles[i].setValidDestination();
			} 
			else if (crd == null)
				return;
		}
	}

	private void resetValidDestinations() {
		for (int i = 0; i < allPiles.length; i++) {
			allPiles[i].resetValidDestination();
		}
	}

	// set the card to null
	private void restoreSelectedCard() {
		selectedCardSource.addCard(selectedCard);
		selectedCard = null;
		selectedCardSource = null;
		resetValidDestinations();
	}

	// place the card
	private void placeSelectedCard(CardPile crdDestination) {
		crdDestination.addCard(selectedCard);
		resetValidDestinations();
		selectedCard = null;
		selectedCardSource = null;
		checkWinner();
	}

	/* check if all decks except the six and seven piles, if those decks are empty
	 * that means the player has won. */
	private void checkWinner() {
		if ((allPiles[0].isEmpty() && allPiles[1].isEmpty()) 
			&& (allPiles[6].isEmpty() && (allPiles[7].isEmpty()
			&& allPiles[8].isEmpty() && allPiles[9].isEmpty()
			&& allPiles[10].isEmpty()))) {
			gameWon = true;
		    System.out.println("Congrats, you won the game! :)");
		}
	}

	// restart the program
	private class RestartButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			sortedDeck = false;
			init();
			repaint();
			setNewDecktoZero();
		}
	}

	// play the game with a fixed/sorted deck
	private class RestartButtonFixedDeckListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			sortedDeck = true;
			init();
			repaint();
			setNewDecktoZero();

		}
	}

	// exit game
	private class ExitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	//Get the koordinates and check if they're in the cards frame if so move a card	
	private class MouseKeeper extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			ShowSolitare gameInstance = (ShowSolitare) e.getSource();
			gameInstance.clickController(x, y);
			repaint();
		}
	}

	// print out all the cards
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < allPiles.length; i++)
			allPiles[i].display(g);
	}
}

// Display the game through JFrame
class DisplayGame extends JFrame {

	final int FRAME_SIZE_WIDTH = 600;
	final int FRAME_SIZE_HEIGHT = 600;

	public DisplayGame() {
		super("Solitare");

		setSize(FRAME_SIZE_WIDTH, FRAME_SIZE_HEIGHT);
		setTitle("Napoleon Solitare");
		add(new ShowSolitare());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class Solitare {

	static public void main(String[] args) {
		new DisplayGame();
	}
}