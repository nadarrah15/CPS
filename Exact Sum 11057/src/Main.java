//Binary search M - price[i]
import java.util.Scanner;

public class Main {

	static int N;
	static int[] array;
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		N = reader.nextInt();
		array = new int[N];
		
		for(int i = 0; i < N; i++){
			array[i] = reader.nextInt();
		}
	}

}
