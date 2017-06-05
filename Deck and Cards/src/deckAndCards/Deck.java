package deckAndCards;

import java.util.Iterator;
import java.util.Random;
import java.util.Stack;

public class Deck {
	private Stack<Card> deck;

	public Deck() {
		deck = new Stack<Card>();
		loadDeck();
	}

	public Stack<Card> getDeck() {
		return deck;
	}

	// Load the stack with 52 cards in order
	public void loadDeck() {
		for (int i = 1; i <= 4; i++) {
			for (int j = 2; j <= 14; j++) {
				deck.push(new Card(j, i));
			}
		}
	}

	// Print the stack - for uniformity,
	// make 13 rows in four columns, filling
	// in each row from left to right
	public String toString() {
		String result = "";
		Iterator<Card> iter = deck.iterator();
		while (iter.hasNext()) {
			for (int i = 0; i < 4; i++)
				result += iter.next() + "\t";
			result += "\n";
		}
		return result;
	}

	// Return and remove the top card
	public Card deal() {
		return deck.pop();
	}

	// Take the top half of the deck (26 cards) and alternate card by card with
	// the bottom half
	public void bridgeShuffle() {
		Stack<Card> half1 = new Stack<Card>();
		Stack<Card> half2 = new Stack<Card>();

		for (int i = 0; i < 26; i++) {
			half1.push(deck.pop());
		}
		for (int j = 0; j < 26; j++) {
			half2.push(deck.pop());
		}

		Stack<Card> result = new Stack<Card>();
		for (int k = 0; k < 26; k++) {
			result.push(half2.pop());
			result.push(half1.pop());
		}

		deck = result;
	}

	// Split the deck at a random spot. Put the stack of cards above the random
	// spot below the other cards
	public void cut() {
		Stack<Card> temp = new Stack<Card>();
		Random gen = new Random();
		int num = gen.nextInt(53);

		for (int i = 0; i < num; i++) {
			temp.push(deck.pop());
		}
		combineDecks(temp);
	}

	// Complete a bridge shuffle and then cut the deck. Repeat 7 times
	public void completeShuffle() {
		for (int i = 0; i < 7; i++) {
			bridgeShuffle();
			cut();
		}
	}

	// Reverse the order of the cards in the deck
	private void reverse() {
		Stack<Card> temp = new Stack<Card>();
		while (!deck.isEmpty()) {
			temp.push(deck.pop());
		}
		deck = temp;
	}

	// Given a Stack of cards as an explicit parameter,
	// reverse the order of the cards in the deck
	private Stack<Card> reverse(Stack<Card> x) {
		Stack<Card> temp = new Stack<Card>();
		while (!x.isEmpty()) {
			temp.push(x.pop());
		}
		return temp;
	}

	// Combine two decks, one as the implicit
	// parameter, the other as the explicit parameter
	public void combineDecks(Stack<Card> other) {
		Stack<Card> temp = reverse(other);
		while (!temp.isEmpty()) {
			deck.push(temp.pop());
		}
	}

	public static void main(String[] args) {
		// example method calls - you should make your own
		Deck a = new Deck();
		System.out.println("Display after DECK CONSTRUCTION \n" + a + "\n\n");

		a.cut();
		System.out.println("Display after CUT \n" + a + "\n\n");

		a.bridgeShuffle();
		System.out.println("Display after BRIDGE SHUFFLE \n" + a + "\n\n");

	}
}
