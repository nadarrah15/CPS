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
	
	static void dfs(){
		boolean[] visited = new boolean[graph.size()];
		//bm
	}
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		int T = reader.nextInt();
		
		for(int count = 0; count < T; count++){
			int N = reader.nextInt();
			
			for(int i = 1; i <= N; i++){
				graph.add(new Vertex(i));
			}
			
			for(int i = 0; i < N; i++){
				int u = reader.nextInt(), v = reader.nextInt();
				graph.get(u - 1).edges.add(new Edge(v));
				graph.get(v - 1).edges.add(new Edge(u));
			}
			
			dfs();
		}
	}

}
