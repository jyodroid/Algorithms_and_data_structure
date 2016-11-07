package algoritms_data_structures;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

/**
 * Finds if a magazine  can be used to create a note
 * @author jyodroid
 *
 */
public class Maps {
	Map<String, Integer> magazineMap;
	Map<String, Integer> noteMap;

	public Maps(String magazine, String note) {
		magazineMap = new HashMap<>();
		noteMap = new HashMap<>();
		String token = " ";
		StringTokenizer tokenizerMagazine = new StringTokenizer(magazine, token);
		while (tokenizerMagazine.hasMoreTokens())
		{
			//if token already exists put quantity on value
			String word = tokenizerMagazine.nextToken();
			if (magazineMap.containsKey(word)){
				magazineMap.put(word, magazineMap.get(word) + 1);
			}else{
				magazineMap.put(word, 1);
			}
		}
		StringTokenizer tokenizerNote = new StringTokenizer(note, token);
		while (tokenizerNote.hasMoreTokens())
		{
			//if token already exists put quantity on value
			String word = tokenizerNote.nextToken();
			if (noteMap.containsKey(word)){
				noteMap.put(word, noteMap.get(word) + 1);
			}else{
				noteMap.put(word, 1);
			}
		}
	}

	public boolean solve() {
		Iterator it = noteMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> pairs = (Entry<String, Integer>) it.next();
			String  key = pairs.getKey();
			Integer value = pairs.getValue();
			if(!magazineMap.containsKey(key)){
				return false;
			}else if(magazineMap.get(key) < value){
				return false;
			}
		}
		return true;
	}
}
