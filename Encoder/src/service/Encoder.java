package service;

import constant.ReferenceTable;

public class Encoder {
    // Returns true if the character is found in the reference table
    public boolean existInReferenceTable(Character letter) {
	for(Character c : ReferenceTable.referenceTable) {
	    if(c.equals(letter)) {
		return true;
	    }
	}
	return false;
    }
    
    // Returns an encoded character
    public Character encodeByCharacter(Character letter, Character offset) {
	int position = 0;
	
	if(existInReferenceTable(letter) && existInReferenceTable(offset)) {
	    position = ReferenceTable.referenceTable.indexOf(letter);
	    position -= ReferenceTable.referenceTable.indexOf(offset);
	}
	else
	    return null;
	
	// To account for negative cases
	if(position < 0)
	    position += ReferenceTable.referenceTable.size();
	
	return ReferenceTable.referenceTable.get(position);
    }
    
    // Returns an encoded string
    public String encode(String text, String offset) {
	String result = null;
	
	if(existInReferenceTable(offset.trim().charAt(0))) {
	    result = "";
	    
	    for(int i=0; i<text.length(); i++) {
		// To account for whitespace
		if(Character.valueOf(text.charAt(i)).equals(' ')) {
		    result += text.charAt(i);
		}
		else {
		    Character encodedCharacter = encodeByCharacter(text.charAt(i), offset.trim().charAt(0));
		    if(encodedCharacter != null)
			result += encodedCharacter;
		    else
			return null; // as long as an encoded character is null, return a null string
		}
	    }
	}
	return result;
    }
    
    // Returns a decoded character
    public Character decodeByCharacter(Character letter, Character offset) {
	int position = 0;
	
	if(existInReferenceTable(letter) && existInReferenceTable(offset)) {
	    position = ReferenceTable.referenceTable.indexOf(letter);
	    position += ReferenceTable.referenceTable.indexOf(offset);
	}
	else
	    return null;
	
	// To account for cases over the limit
	if(position > ReferenceTable.referenceTable.size())
	    position -= ReferenceTable.referenceTable.size();
	
	return ReferenceTable.referenceTable.get(position);
    }
    
 // Returns a decoded string
    public String decode(String text, String offset) {
	String result = null;
	
	if(existInReferenceTable(offset.trim().charAt(0))) {
	    result = "";
	    
	    for(int i=0; i<text.length(); i++) {
		// To account for whitespace
		if(Character.valueOf(text.charAt(i)).equals(' ')) {
		    result += text.charAt(i);
		}
		else {
		    Character decodedCharacter = decodeByCharacter(text.charAt(i), offset.trim().charAt(0));
		    if(decodedCharacter != null)
			result += decodedCharacter;
		    else
			return null; // as long as a decoded character is null, return a null string
		}
	    }
	}
	return result;
    }
}