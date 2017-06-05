package deckAndCards;

public class Card implements Comparable<Card> {
	private int suit;
	private int value;

	public Card() {
		value = 2;
		suit = 1;
	}

	public Card(int v, int s) {
		value = v;
		suit = s;
	}

	public String getSuit() {
		if (suit == 1) {
			return "Clubs";
		}
		if (suit == 2) {
			return "Diamonds";
		}
		if (suit == 3) {
			return "Hearts";
		}
		if (suit == 4) {
			return "Spades";
		}
		return suit + "";
	}

	public String getValue() {
		if (value == 11) {
			return "J";
		}
		if (value == 12) {
			return "Q";
		}
		if (value == 13) {
			return "K";
		}
		if (value == 14) {
			return "A";
		}
		return value + "";
	}

	public String toString() {
		return getValue() + " of " + getSuit();
	}

	public int compareTo(Card other) {
		if (this.value == other.value){
			return 0;
		}
		else if (this.value > other.value){
			return 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		Card one = new Card();
		Card two = new Card(12, 2);
		Card three = new Card(3, 1);
		System.out.println(one);
		System.out.println(two);
		System.out.println(three);
	}
}
