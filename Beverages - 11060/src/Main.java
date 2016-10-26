import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static class Beverage{
		String name;
		ArrayList<String> dependent = new ArrayList<String>();
		
		public Beverage(String name){
			this.name = name;
		}
	}
	
	static ArrayList<Beverage> bev;
	static ArrayList<String> names;
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int count = 0;
		while(reader.hasNext()){
			count++;
			int N = reader.nextInt();
			reader.nextLine();
			bev = new ArrayList<Beverage>();
			
			for(int i = 0; i < N; i++){
				bev.add(new Beverage(reader.nextLine()));
			}
			
			int M = reader.nextInt();
			reader.nextLine();
			for(int i = 0; i < M; i++){
				
			}
		}
	}

}
