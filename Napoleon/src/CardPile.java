
//
//	Abstraction for piles of cards for Solitaire game
//	written by Tim Budd, April 1997
//

import java.awt.*;
import java.util.Stack;
import java.util.EmptyStackException;

public class CardPile {
	// coordinates of the card pile
	protected int x;
	protected int y;
	protected Stack thePile;
	protected boolean validDestination;

	// constructor
	CardPile(int xl, int yl) {
		x = xl;
		y = yl;
		thePile = new Stack();
		validDestination = false;
	}

	// access to cards are not overridden
	public final Card top() {
		return (Card) thePile.peek();
	}

	public final boolean isEmpty() {
		return thePile.empty();
	}

	public boolean isValidDestination() {
		return validDestination;
	}

	public void setValidDestination() {
		validDestination = true;
	}

	public void resetValidDestination() {
		validDestination = false;
	}

	public final Card pop() {
		try {
			return (Card) thePile.pop();
		} catch (EmptyStackException e) {
			return null;
		}
	}

	// the following are sometimes overridden
	public boolean includes(int tx, int ty) {
		return x <= tx && tx <= x + Card.width && y <= ty && ty <= y + Card.height;
	}

	public void addCard(Card aCard) {
		thePile.push(aCard);
	}

	public void display(Graphics g) {
		g.setColor(Color.blue);
		if (isEmpty())
			if (isValidDestination()) {
				g.fillRect(x, y, Card.width, Card.height);
			} else {
				g.drawRect(x, y, Card.width, Card.height);
			}
		else {
			if (isValidDestination()) {
				g.fillRect(x, y, Card.width + 2, Card.height + 2);
			}
			top().draw(g, x, y);
		}
	}

	public boolean canTake(Card aCard) {
		return false;
	}

	public void select(int tx, int ty) {
	}

}
