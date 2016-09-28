import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		while(reader.hasNext()){
			int N = Integer.parseInt(reader.next());
			int[] array = new int[N];
			
			for(int i = 0; i < N; i++){
				array[i] = Integer.parseInt(reader.next());
			}
			
			int M = Integer.parseInt(reader.next());
			reader.nextLine();
			reader.nextLine();
			
			Arrays.sort(array);
			
			int x = 0;
			int y = 0;
			
			int i = 0;
			int j = N - 1;
			
			while(i < j){
				if(array[i] + array[j] > M)
					j--;
				else if(array[i] + array[j] < M)
					i++;
				else if(array[i] + array[j] == M){
					if(x == 0 && y == 0){
						if(array[i] <= array[j]){
							x = array[i];
							y = array[j];
						}
						else{
							x = array[j];
							y = array[i];
						}
					}
					else{
						if(array[i] >= array[j] && array[i] - array[j] < y - x){
							x = array[j];
							y = array[i];
						}
						else if(array[i] <= array[j] && array[j] - array[i] < y - x){
							x = array[i];
							y = array[j];
						}
					}
					
					i++;
					j--;
				}
			}
			
			System.out.println("Peter should buy books whose prices are " + x + " and " + y + ".\n");
		}
	}
}