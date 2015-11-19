import java.io.File;
import java.io.IOException;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

public class BoggleDictionary{

	private NavigableSet<String> dictionary;
        
	public BoggleDictionary(String wordList) throws IOException{
		
		dictionary = new TreeSet<String>(); 
		readDict(wordList);
	}
      
    //fills the Dictionary TreeSet with the given text file that contains words.
	public void readDict(String wordList) throws IOException {
		File fileName = new File(wordList);
		Scanner scan = new Scanner(fileName);
        while (scan.hasNextLine()) {
        	String entry = scan.nextLine();
            //Skipping any words of length 2 because we only want the words that are length 3 and >
            if (entry.length() > 2){
            	dictionary.add(entry.toUpperCase());
            }   
        }
     }
      
     //Method that searches the tree for the word nearest to the given string
     //and then sees if that word actually contains the given string and it might 
     //have the potential to become a word. 
     public boolean possibleWord(String str){
        str = str.toUpperCase();
        String word = dictionary.ceiling(str);
        if (word == null){
           return false;
        }
        return (word.contains(str));
     }

     //Checks to see if the String is an actual word in the TreeSet dictionary as is.
     public boolean isWord(String str){
        return dictionary.contains(str);
     }
}