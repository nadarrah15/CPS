import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		
		int N = reader.nextInt();
		int[] a = new int[N];
		for(int i = 0; i < N; i++){
			a[i] = reader.nextInt();
		}
		
		int T = reader.nextInt();
		
		long subsets = (1 << N);
		boolean found = false;
		
		for(long val = 1; val < subsets; val++){
			String rep = Long.toBinaryString(val);
			int sum = 0;
			for(int i = 0; i < N; i++){
				if(rep.charAt(rep.length() - 1 - i) == '1'){
					sum += a[i];
				}
			}
			if(sum == T){
				found = true;
				break;
			}
		}
		
		if(found)
			System.out.println("Yes");
		else
			System.out.println("no");
	}
}
