package JobApp;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

import javax.swing.JOptionPane;


public class Validation {

	//Method to validate data
	public boolean validateData(String data){
		
		StringCharacterIterator iterate=new StringCharacterIterator(data);
		
		char  charac=iterate.current();
		
		while(charac!=CharacterIterator.DONE){
			
			boolean valid=(Character.isAlphabetic(charac) || Character.isSpaceChar(' ') || charac =='@' || charac=='.' || Character.isDigit(charac));
			
			if(!valid){
				
				JOptionPane.showMessageDialog(null, "Enter valid format","Error",JOptionPane.ERROR_MESSAGE);
			return true;	
			}
			
			charac=iterate.next();
		}
			return false;
	}
}

