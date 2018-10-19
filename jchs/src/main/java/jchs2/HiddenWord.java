package jchs2;

public class HiddenWord {
	
	private String word;
	
	public HiddenWord(String word) {
		this.word = word;
	}
	
	public String getHint(String guess) {
		String hint ="";
		for (int i=0; (word.length()==guess.length() && i<word.length()); i++){
			if (guess.charAt(i)==(word.charAt(i))){
				hint += word.charAt(i);
			} else if (word.indexOf(guess.charAt(i))>=0){
				hint += '+';
			} else {
				hint += '*';
			}
		}
		return hint;
	} 

}
