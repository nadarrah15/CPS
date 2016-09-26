import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int M;

	public static void main(String[] args) {
	
		Scanner reader = new Scanner(System.in);
		while(reader.hasNext()){
			
			int N = reader.nextInt();
			int[] array = new int[N];
			
			for(int i = 0; i < N; i++){
				array[i] = reader.nextInt();
			}
			
			M = reader.nextInt();
			reader.nextLine();
			reader.nextLine();
			int answerOne = 0;
			int answerTwo = 0;
			Arrays.sort(array);
			for(int i = N / 2; i >= 0; i--){
				answerOne = array[i];
				answerTwo = binarySearch(array, array[i]);
				
				if(answerTwo != 0 && answerTwo != -1) break;
			}
			
			if(answerOne < answerTwo){
				System.out.println("Peter should buy books whose prices are " + answerOne + " and " + answerTwo + ".");
				System.out.println("");
			}
			else{
				System.out.println("Peter should buy books whose prices are " + answerTwo + " and " + answerOne + ".");
				System.out.println("");
			}
		}
	}

	public static int binarySearch(int[] array, int num) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (M - num == array[mid]) {
				return array[mid];
			} 
			else if (M - num > array[mid])
				low = mid + 1;
			else if (M - num < array[mid])
				high = mid - 1;
		}

		return -1;
	}
}
