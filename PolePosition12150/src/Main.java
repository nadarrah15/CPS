import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//create a scanner to read the input
		Scanner reader = new Scanner(System.in);
		
		//loop to read all inputs into an ArrayList 
		//breaks when the EOF character is put in
		while (true){
			int x = reader.nextInt();
			if(x == 0) break;
			else{
				
				for(; x > 0; x--){
					int number = reader.nextInt();
					int positions = reader.nextInt();
				}
			}
		}
	}
}
