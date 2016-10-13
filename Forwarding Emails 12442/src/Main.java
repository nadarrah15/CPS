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
	static int max;
	static int start;
	
	static void dfs(int v, boolean[] visited){
		visited[v] = true;
		
		ArrayList<Edge> edges = graph.get(v).edges;
		for(int i = 0; i < edges.size(); i++){
			int w = edges.get(i).dest - 1;
			
			if(!visited[w]){
				count++;
				dfs(w, visited);
				
				if(count > max){
					max = count;
					start = w;
				}
			}
		}
	}
	
	static void dfs(){
		boolean visited[] = new boolean[graph.size()];
		
		dfs(0, visited);
		
		for(int i = 0; i < visited.length; i++){
			if(!visited[i]){
				count = 1;
				visited = new boolean[graph.size()];
				dfs(i, visited);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		int T = reader.nextInt();
		
		for(int i = 1; i <= T; i++){
			graph = new ArrayList<Vertex>();
			int N = reader.nextInt();
			
			for(int j = 1; j <= N; j++){
				graph.add(new Vertex(j));
			}
			
			for(int j = 0; j < N; j++){
				int u = reader.nextInt(), v = reader.nextInt();
				graph.get(u - 1).edges.add(new Edge(v));
			}
			
			dfs();
			
			System.out.print("Case " + i + ": " + start);
			if(i != T) System.out.println();
			
			count = 1;
			max = count;
			start = 50000;
		}
	}

}
