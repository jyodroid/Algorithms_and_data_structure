/**
 * two Strings A and B are considered anagram if first String's letters can be rearranged 
 * so A and B are equals 
 */
package algoritms_data_structures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jyodroid
 *
 */
public class Anagrams {

	public boolean isAnagram(String a, String b){
		
		//Special cases
		if (a.equals(b)) return true;
		if (a.length() != b.length()) return false;
		
		for(int b_i = 0; b_i < b.length(); b_i++){
			//Brute force 
			//find element of b in a and match positions
			
			for (int a_i = b_i;a_i < a.length();a_i++){
				
				//switch a characters 
				if(a.charAt(a_i) == b.charAt(b_i)){
					a = switchCharacters(a, b_i, a_i);
					//start from switched position next element
					continue;
				}
				
				//If after switch we found anagram return true
				if(a.equals(b)){
					return true;
				}
			}
		}
		
		return false;
	}
	
	public String switchCharacters(String string, int fromIndex, int toIndex) 
			throws IndexOutOfBoundsException{
		
		//indexes out of bound
		if (fromIndex > string.length() - 1 || toIndex > string.length() - 1){
			throw new IndexOutOfBoundsException("invalid indexes");
		}	
		
		char temp = string.charAt(fromIndex);
		StringBuilder newString = new StringBuilder(string);
		newString.setCharAt(fromIndex, string.charAt(toIndex));
		newString.setCharAt(toIndex, temp);
		
		return newString.toString();
	}
	
    public List<String> buildAnagrams(String string){
        List<String> anagrams = new ArrayList<>();
        for(int i = 0; i < string.length() - 1; i++){
            for(int j = i + 1; j < string.length(); j ++){
                if(string.charAt(i) == string.charAt(j)){
                    continue;
                }
                String newString = switchCharacters(string, i, j);
                if(!string.equals(newString) && !anagrams.contains(newString)){
                    anagrams.add(newString);
                }
            }
        }
        return anagrams;
    }
}
