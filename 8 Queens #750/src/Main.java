import java.util.Scanner;

public class Main {
	
	public static class Board{
		
		// creates an unpopulated board
		private int[][] board = {
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0}
		};
		
		public void placeQueen(int x, int y){
			board[x][y] = 1;
		}
		
		public boolean isSafe(int x, int y){
			if(board[x][y] == 0) return true;
			else return false;
		}
		
	}
	
	// 0 is safe, 1 is a queen, 2 is dangerous
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		// places a queen on the board
		int x = reader.nextInt(), y = reader.nextInt();
		
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				
			}
		}
	}

}
