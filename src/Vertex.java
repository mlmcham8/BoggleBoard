import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	private int x; // The x coordinate of the cell
	private int y; // The y coordinate of the cell
	private char vertex; // The character of the cell
	boolean seen; 
	
	// The list of this cell's neighboring cells
	private List<Vertex> neighbors = new ArrayList<Vertex>();
	
	//Vertex constructor that take the x value and y value of where 
	public Vertex(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// function to get the character to a certain vertex 
	public char getCharacter() {
		return vertex;
	}
	
	// function to check in the vertex is seen
	public boolean isSeen(Vertex c){
		return c.seen = true;
	}
	
	//set a character to this vertex object 
	public void setCharacter(char character) {
		this.vertex = character;
	}
	
	//get the x value
	public int getX() {
		return x;
	}

	// get the y value
	public int getY() {
		return y;
	}
	
	//add a neighbor(cell) to the arraylist neighbors
	public void addNeighbor(Vertex cell) {
		this.neighbors.add(cell);
	}

	//get the list associated this vertex object
	public List<Vertex> Adj() {
		return neighbors;
	}
}