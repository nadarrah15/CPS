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
			int i;
			Arrays.sort(array);
			if(N % 2 == 0){
				i = N / 2;
			}
			else {
				i = N / 2 + 1;
			}
			for(; i >= 0; i--){
				answerOne = array[i];
				answerTwo = binarySearch(array, i);
				
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

	public static int binarySearch(int[] array, int index) {
		int low = 0;
		int high = array.length - 1;
		boolean incr = true;
		while (low <= high) {
			int mid = (low + high) / 2;
			if(M - array[index] == array[mid] && mid != index) {
				return array[mid];
			} 
			else if (M - array[index] > array[mid]){
				low = mid + 1;
				incr = true;
			}
			else if (M - array[index] < array[mid]){
				high = mid - 1;
				incr = false;
			}
			else{
				if(incr) low++;
				else high--;
			}
		}

		return -1;
	}
}
