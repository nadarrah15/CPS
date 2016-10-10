import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFS {
	
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
	
	static void dfs(int v, boolean[] visited){
		visited[v] = true;
		
		ArrayList<Edge> edges = graph.get(v).edges;
		for(int i = 0; i < edges.size(); i++){
			int w = edges.get(i).dest;
			
			if(!visited[w])
				dfs(w, visited);
		}
	}
	
	static boolean dfs(){
		boolean visited[] = new boolean[graph.size()];
		
		dfs(0, visited);
		
		boolean connected = true;
		for(int i = 0; i < visited.length; i++){
			if(!visited[i]){
				connected = false;
				break;
			}
		}
		
		return connected;
	}
	
	static boolean bfs(){
		boolean[] visited = new boolean[graph.size()];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(0);
		while(!queue.isEmpty()){
			int v = queue.remove();
			if(visited[v])
				continue;
			
			visited[v] = true;
			
			ArrayList<Edge> edges = graph.get(v).edges;
			for(int i = 0; i < edges.size(); i++){
				int w = edges.get(i).dest;
				if(!visited[w]){
					queue.add(w);
				}
			}
		}
		
		boolean connected = true;
		for(int i = 0; i < visited.length; i++){
			if(!visited[i]){
				connected = false;
				break;
			}
		}
		
		return connected;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner reader = new Scanner(new File("input.txt"));

		int N = reader.nextInt();
		int M = reader.nextInt();
		
		graph = new ArrayList<Vertex>();
		
		for(int i = 0; i < N; i++){
			graph.add(new Vertex(i));
		}
		
		for(int i = 0; i < M; i++){
			int u = reader.nextInt();
			int v = reader.nextInt();
			
			graph.get(u).edges.add(new Edge(v));
			graph.get(v).edges.add(new Edge(u));
		}
		
		for(int i = 0; i < graph.size(); i++){
			System.out.print(i + ": ");
			for(int j = 0; j < graph.get(i).edges.size(); j++){
				System.out.print(graph.get(i).edges.get(j).dest + ", ");
			}
			System.out.println();
		}
		
		boolean connected = dfs();
		System.out.println(connected);
	}

}
