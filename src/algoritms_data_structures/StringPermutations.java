package algoritms_data_structures;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
	
	public List<String> getStringPermutattions(String word){
		
		List<String> permutationStrings = new ArrayList<>();
		if(isAWord(word)){
			permutationStrings.add(word);
		}
		
		StringBuilder permutedWordBuilder = new StringBuilder(word);
		
		for (int i = 0; i < permutedWordBuilder.length(); i++) {
			permutationStrings.addAll(permuteInWord(permutedWordBuilder.charAt(i), i, permutedWordBuilder));
		}
		
		return permutationStrings;
	}
	
	private char[] nearestChars(char charInWord){
		return new char[] {'a','b','c'};
	}
	
	private boolean isAWord(String word){
		
		String[] dictionary = {"Hello", "Hallo"};
		
		for (int i = 0; i < dictionary.length; i++) {
			if (dictionary[i].equals(word)) return true;
		}
		
		return false;
	}
	
	
	private List<String> permuteInWord(char charInWord, int indexOfChar, StringBuilder permutedWordBuilder){
		List <String> permutedWords = new ArrayList<>();
		char original = permutedWordBuilder.charAt(indexOfChar);
		for (char charToPermut : nearestChars(charInWord)) {
			permutedWordBuilder.setCharAt(indexOfChar, charToPermut);
			if(isAWord(permutedWordBuilder.toString())){
				permutedWords.add(permutedWordBuilder.toString());
			}
		}
		permutedWordBuilder.setCharAt(indexOfChar, original);
		return permutedWords;
	}
	
	public static void main(String[] args) {
		StringPermutations sp = new StringPermutations();
		for (String string : sp.getStringPermutattions("Hello")) {
			System.out.println(string);
		}
	}
	
}
