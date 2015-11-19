import java.io.IOException;
import java.util.ArrayList;

public class Boggle {
	Graph G; //graph the hold the boggle board
	BoggleDictionary dictionary; //dictionary of words
    ArrayList<String> validWords; //array of valid words found 
    
    //default constructor
    public Boggle() {
    	validWords  = new ArrayList<String>();
    }
    
    //function that runs it all 
	public void runBoggle(String board, String wordList) throws IOException{
		G = new Graph(board); //initializes G and generates boggle board
		G.display(); //displays Graph(boggle board)
		System.out.println();
		dictionary = new BoggleDictionary(wordList); //creates a new dictionary and reads in words
		findWords(); //runs DFS and prints out all validWords
	}
	
	public void findWords(){
		//runs DFS on every part of the board to find all valid words
		for (Vertex v : G.V()) {
			DFS(v, "");
		}
		
		//prints out all valid word found 
		System.out.println("Valid Words Found:");
		for ( String word :  validWords){ 
			System.out.println(word);
		}
		System.out.println();
		
		//prints out the total of valid words
		System.out.println(validWords.size() + " words found."); 
	}

	private void DFS(Vertex x,String letters){
		//changing Q to QU and set that to a new String 
		letters = letters + (x.getCharacter() == 'Q' ? "QU" : x.getCharacter()); 

		if (!dictionary.possibleWord(letters)) { return;} //check if letters can be a word if not return
		
		validateWords(letters);//run function to check if valid word
	    
		x.seen = true; //mark at seen because we are not allowed to reuse a letter
		
		//runs dfs on each neighbor(edge) of the Vertex letter
		for(Vertex y : G.Adj(x)){
			if (!y.seen == true)
				DFS(y,letters);	
		}
		x.seen = false; // resets to false
	}
	
	//checks to see if the letters is a valid word and if the array has it already
	//if the array list validWords does not have word you add it to the growing array of words
	public void validateWords(String word){
		if (dictionary.isWord(word)){
			if (!validWords.contains(word)){
				validWords.add(word); 
			}
		}
	}
}
