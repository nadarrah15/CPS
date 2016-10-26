import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static ArrayList<String> bev;
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int count = 0;
		while(reader.hasNext()){
			count++;
			int N = reader.nextInt();
			reader.nextLine();
			bev = new ArrayList<String>();
			
			for(int i = 0; i < N; i++){
				String name = reader.nextLine();
				bev.add(name);
			}
			
			int M = reader.nextInt();
			reader.nextLine();
			for(int i = 0; i < M; i++){
				String u = reader.next();
				String v = reader.next();
				
				if(bev.indexOf(u) > bev.indexOf(v)){
					bev.add(bev.indexOf(v), bev.remove(bev.indexOf(u)));
				}
				reader.nextLine();
			}
			
			System.out.print("Case #" + count + ": Dilbert should drink beverages in this order: " + bev.get(0));
			for(int i = 1; i < bev.size(); i++)
				System.out.print(" " + bev.get(i));
			
			System.out.println("");
		}
	}

}
