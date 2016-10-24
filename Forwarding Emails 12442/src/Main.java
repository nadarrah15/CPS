import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static ArrayList<Integer> graph;
	static int count;
	
	static int chain(int i){
		boolean[] visited = new boolean[graph.size()];
		visited[i] = true;
		
		int w = graph.get(i) - 1;
		count = 1;
		chain(w, visited);
		
		return count;
	}
	
	static void chain(int i, boolean[] visited){
		visited[i] = true;
		
		int w = graph.get(i) - 1;
		if(!visited[w]){
			count++;
			chain(w, visited);
		}
	}
	
	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		
		int T = reader.nextInt();
		for(int Case = 1; Case <= T; Case++){
			graph = new ArrayList<Integer>();
			int N = reader.nextInt();
			
			for(int i = 1; i <= N; i++){
				graph.add(null);
			}
			
			for(int i = 0; i < N; i++){
				int u = reader.nextInt(), v = reader.nextInt();
				graph.set(u - 1, v);
			}
			
			int max = 0;
			int point = 0;
			for(int i = 0; i < N; i++){
				int length = chain(i);
				if(length > max){
					point = i + 1;
					max = length;
				}
				if(length == N - 1) break;
			}
			System.out.print("Case " + Case + ": " + point);
			if(Case < N) System.out.println();
		}
	}
}