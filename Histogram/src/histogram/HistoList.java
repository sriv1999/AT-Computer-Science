package histogram;
import java.util.*;

public class HistoList {
	private HistoNode front;

	public HistoList() {
		front = null;
	}

	// addLetter will add a new node to the front for let if let does not exist
	// addLetter will bump up the count if let already exists
	public void addLetter(char let) {
		if (front == null)
			front = new HistoNode(let, 0, null);
		
		HistoNode temp = front;
		boolean finished = false;
		while (temp != null){
			if (temp.getLetter() == let){
				temp.setLetterCount(temp.getLetterCount() + 1);
				finished = true;
			}
			temp = temp.getNext();
		}
		
		if (finished == false){
			HistoNode one = new HistoNode(let, 1, front);
			front = one;
		}

	}
	
	public void removeLetter(char let) {		
		HistoNode temp = front;
		while (temp != null){
			if (temp.getLetter() == let){
				temp.setLetterCount(temp.getLetterCount() - 1);
			}
			temp = temp.getNext();
		}
	}

	// returns the index pos of let in the list if let exists
	public int indexOf(char let) {

		return -1;
	}

	// returns a reference to the node at spot
	private HistoNode nodeAt(int spot) {
		HistoNode current = null;

		return current;
	}

	// returns a string will all values from list
	public String toString() {
		String output = "";
		HistoNode temp = front;
		while (temp != null){
			output += temp.getLetter() + " - " + temp.getLetterCount() + "\t";
			temp = temp.getNext();
		}
		return output;
	}
}