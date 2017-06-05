package wordamounts;

public class WordTally {
	private String word;
	private int frequency;
	
	public WordTally(String w, int f){
		word = w;
		frequency = f;
	}

	public String getWord() {
		return word;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int f) {
		frequency = f;
	}
}
