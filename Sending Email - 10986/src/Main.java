import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static class Edge{
		int dest;
		int weight;
		
		Edge(int d, int w) {
			dest = d;
			weight = w;
		}
	}
	
	static class Vertex{
		ArrayList<Edge> edges;
		int name;
		
		Vertex(int n) {
			name = n;
			edges = new ArrayList<Edge>();
		}
	}
	
	static ArrayList<Vertex> graph;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		for(int Case = 1; Case <= N; Case++){
			int n = in.nextInt(), m = in.nextInt(), S = in.nextInt(), T = in.nextInt();
			
			for(int i = 0; i < n; i++){
				graph.add(new Vertex(i));
			}
			
			for(int i = 0; i < m; i++){
				int a = in.nextInt(), b = in.nextInt(), w = in.nextInt();
				
				graph.get(a).edges.add(new Edge(b, w));
				graph.get(b).edges.add(new Edge(a, w));
			}
			
			int[] path = new int[n];
			
			Queue<Vertex> q = new PriorityQueue<Vertex>();
			q.add(graph.get(S));
			while(!q.isEmpty()){
				Vertex v = q.peek();
			}
		}
	}
}
