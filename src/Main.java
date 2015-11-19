import java.io.IOException;

/**
 * 
 * @author Madison McHam, Project 5, CS360 Spring 2015
 * This is a Boggle programming project that is designed to	put	out	as many words as quickly as possible. I step up the program
 * to run DFS on every vertex and loop through all the neighbors and find valid words inside the given dictionary. I choose to do DFS
 * because with DFS we have the ability to do backtracking and that makes it easier to find connecting words for this Boggle programming 
 * assignment. 
 *  
 */

public class Main {
	
	public Boggle boggle = new Boggle();
	
	public static void main(String[] args) throws IOException{
		Main obj = new Main();    
        obj.boggle.runBoggle("board.txt","dict.txt");
    }

}
