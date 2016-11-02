import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static class Edge {
		int dest;
		
		Edge(int d) {
			dest = d;
		}
	}
	
	static class Vertex {
		ArrayList<Edge> edges;
		int name;
		
		Vertex(int n) {
			name = n;
			edges = new ArrayList<Edge>();
		}
	}
	
	static ArrayList<String> bev;
	static ArrayList<Vertex> graph;
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int count = 0;
		while(reader.hasNext()){
			count++;
			int N = reader.nextInt();
			reader.nextLine();
			bev = new ArrayList<String>();
			graph = new ArrayList<Vertex>();
			
			for(int i = 0; i < N; i++){
				bev.add(reader.nextLine());
				graph.add(new Vertex(i));
			}
			
			int[] indeg = new int[bev.size()];
			
			int M = reader.nextInt();
			reader.nextLine();
			for(int i = 0; i < M; i++){
				int a = bev.indexOf(reader.next()), b = bev.indexOf(reader.next());
				ArrayList<Edge> edges = graph.get(i).edges;
				edges.add(new Edge(b));
			}
			
			for (int i=0; i<graph.size(); ++i) {
				ArrayList<Edge> edges = graph.get(i).edges;
				
				for (int j = 0; j < edges.size(); ++j) {
					++indeg[edges.get(j).dest];
				}
			}
			
			Queue<Integer> q = new LinkedList<Integer>();
			
			for(int i = 0; i < indeg.length; i++)
				if (indeg[i] == 0)
					q.add(i);
			
			System.out.print("Case # "+ count + ": Dilbert should drink beverages in this order:");
			
			while (!q.isEmpty()) {
				// find a vertex with in-degree 0
				int v = q.remove();
				
				// add it to the list
				System.out.print(" " + bev.get(v));
				
				// decrease the in-degrees of v's neighbors
				ArrayList<Edge> edges = graph.get(v).edges;
				for (int i = 0; i < edges.size(); i++) {
					int w = edges.get(i).dest;
					--indeg[w];
					if (indeg[w] == 0)
						q.add(w);
				}
			}
		}
	}

}
