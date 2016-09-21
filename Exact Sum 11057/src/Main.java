import java.util.Arrays;
import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		while(reader.hasNext()){
			
			int N = reader.nextInt();
			int[] array = new int[N];
			
			for(int i = 0; i < N; i++){
				array[i] = reader.nextInt();
			}
			
			int M = reader.nextInt();
			
			
			Arrays.sort(array);
			int answerOne = 0;
			int answerTwo = 0;
			int i = 0;
			int j = array.length - 1;
			while(i < j){
				if(array[i] + array[j] > M){
					j = (i + j) / 2;
				}
				else if(array[i] + array[j] < M){
					i = (i + j) / 2;
				}
				else {
					answerOne = array[i];
					answerTwo = array[j];
				}
			}
			
			System.out.println("Peter should buy books whose prices are " + answerOne + " and " + answerTwo);
			System.out.println("");
		}
	}
}
