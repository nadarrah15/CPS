import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		while(true){
			int n = reader.nextInt();
			int d = reader.nextInt();
			int r = reader.nextInt();
			
			if(n == 0 && d == 0 && r == 0) break;
			
			int[] day = new int[n];
			for(int i = 0; i < n; i++){
				day[i] = reader.nextInt();
			}
			reader.nextLine();
			
			int[] evening = new int[n];
			for(int i = 0; i < n; i++){
				evening[i] = reader.nextInt();
			}
			reader.nextLine();
			
			Arrays.sort(day);
			Arrays.sort(evening);
			
			int sum = 0;
			for(int i = 0; i < n; i++){
				int temp = day[i] + evening[evening.length - i - 1] - d;
				if(temp > 0) sum += temp;
			}
			
			System.out.println(sum * r);
		}
	}

}
