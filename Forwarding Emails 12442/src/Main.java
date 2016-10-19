import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static class Edge{
		int dest;
		
		Edge(int d){
			dest = d;
		}
	}
	
	static class Vertex{
		ArrayList<Edge> edges;
		int name;
		
		Vertex(int n){
			name = n;
			edges = new ArrayList<Edge>();
		}
	}
	
	static ArrayList<Vertex> graph;
	static int count;
	
	static int chain(int i){
		boolean[] visited = new boolean[graph.size()];
		visited[i] = true;
		
		int w = graph.get(i).edges.get(0).dest - 1;
		count = 1;
		chain(w, visited);
		
		return count;
	}
	
	static void chain(int i, boolean[] visited){
		visited[i] = true;
		
		int w = graph.get(i).edges.get(0).dest - 1;
		if(!visited[w]){
			count++;
			chain(w, visited);
		}
	}
	
	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		
		int T = reader.nextInt();
		for(int Case = 1; Case <= T; Case++){
			graph = new ArrayList<Vertex>();
			int N = reader.nextInt();
			
			for(int i = 1; i <= N; i++){
				graph.add(new Vertex(i));
			}
			
			for(int i = 0; i < N; i++){
				int u = reader.nextInt(), v = reader.nextInt();
				graph.get(u - 1).edges.add(new Edge(v));
			}
			
			int max = 0;
			int point = 50000;
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