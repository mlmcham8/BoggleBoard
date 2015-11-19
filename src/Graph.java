import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Graph {

	private int row; // number of rows
    private int col; //number of columns      
	Vertex[][] board; //2d Vertex array to hold board
	private ArrayList<Vertex> vertices = new ArrayList<Vertex>();
	
	//constructor that reads in fileName
	public Graph (String fileName) throws IOException {
	       inputBoard(fileName);       
	   }
	
	 //inputs the test from file into graph of adjacency matrices
	 public void inputBoard(String fileName) throws IOException{
		 File file = new File(fileName); //read board.txt file
		 @SuppressWarnings("resource") 
		 BufferedReader scan = new BufferedReader(new FileReader(file)); 
		 String line = scan.readLine(); //read first line and get the dimensions
		 String[] set = line.split(" "); //split the string because its space delimited
		 row = Integer.parseInt(set[0]); //row number
		 col = Integer.parseInt(set[1]); //column number
	
		 board = new Vertex[row][col]; //initializes board with the given row size and column size
		 int r = 0;
		 while(( line = scan.readLine())!= null){
				//split the string into individual letters  
				 String[] letters  = line.split(" "); 
				 // loop through the string array length
				 for (int c = 0; c <letters.length;c++){ 
					// check for the QU case
					 if (letters[c] ==  "QU"){  
						letters[c] = "Q";	
					 }
					 Vertex cell = new Vertex(r,c); //create new Vertex 
					 cell.setCharacter(letters[c].charAt(0)); //set the character of the cell to the letter
					 board[r][c] = cell;//assign cell to the board in the position [r][c]
					 vertices.add(cell); // adding the newly created cell to an arrayList containing all cells
				 }
				 r++;
			}
		 getAdjacent(); //set the neighbors of the graph 
	 }
	
	 //testing to see if the board is printing out properly  
	 public void display(){
		 System.out.println("Boggle Board:");
		 for (int i = 0; i < row; i++){
			for (int j = 0; j < col; j++)
				 System.out.print(board[i][j].getCharacter() + " ");
			 System.out.println();
		 }
	 }
	 //assign the neighbors of each vertex on the board
	 public void getAdjacent() {
		 for (int y = 0; y < row; y++) {
			 for (int x = 0; x < col; x++) {
				 // Check if the vertex is on the edge of the board
				 int top = (y != 0) ? -1 : 0;
				 int bottom = (y != row - 1) ? 1 : 0;
				 int left = (x != 0) ? -1 : 0;
				 int right = (x != col - 1) ? 1 : 0;
					
				 // Loop trough all adjacent vertices and add them to the neighbors list
				 for (int i = top; i <= bottom; i++ ) {
					 for (int j = left; j <= right; j++) {
						 // Make sure the vertex doesn't add itself as neighbor
						 if (!(i == 0 && j == 0)) {
							 // Add the vertex to the neighbors list
							 getVertex(x, y).addNeighbor(getVertex(x + j, y + i));
						 }
					 }
				 }
			 }
		 }
	 }
	 
	 // function to call a given vertex's adjacent cells
	 public List<Vertex> Adj(Vertex x){
		 return x.Adj();
	 }

	 //function to call and get board
	 public Vertex[][] getBoard() {
		 return this.board;
	 }
	
	 //get the cell with the given 
	 public Vertex getVertex(int x, int y) {
		 return board[x][y];
	 }
	 
	 // function to return a the arraylist of all vertices 
	 public ArrayList<Vertex> V(){
		 return vertices;
	 }
	 
	 //returns the number of rows
	 public int rows(){
		 return row;
	 }
	 
	 //returns the number of columns 
	 public int cols(){
		 return col;
	 }
}
