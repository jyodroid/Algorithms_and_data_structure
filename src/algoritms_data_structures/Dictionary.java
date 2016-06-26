package algoritms_data_structures;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

	private List<String> names;
	private List<String> professions;
	private static final int NOT_FOUND = -1;
	
	public Dictionary(){
		names = new ArrayList<>();
		professions = new ArrayList<>();
	}
	
	public void addPerson(String personName, String profession){
		int professionIndex = findPersonIndex(personName);
		if(professionIndex == NOT_FOUND){
			this.names.add(personName);
			this.professions.add(profession);
		}else{
			this.professions.set(professionIndex, profession);
		}
	}

	public String getProfession(String personName){
		
		int professionIndex = findPersonIndex(personName);
		if(professionIndex == NOT_FOUND){
			return "Not Found";
		}else{
			return professions.get(professionIndex);
		}
	}
	
	public void removePerson(String personName){
		
		int professionIndex = findPersonIndex(personName);
		if(professionIndex != NOT_FOUND){
			this.names.remove(personName);
			this.professions.remove(professionIndex);
		}
	}
	
	private int findPersonIndex(String personName){
		for (int i = 0; i < names.size(); i++) {
			if(names.get(i).equals(personName)){
				return i;
			}
		}
		return NOT_FOUND;
	}
}
