import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static class Edge{
		int dest;
		boolean used;
		
		public Edge(int d){
			dest = d;
			used = false;
		}
	}
	
	static class Node{
		ArrayList<Edge> edges = new ArrayList<Edge>();
		int n;		//ID number
		
		public Node(int n){
			this.n = n;
		}
	}
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		
		while(true){
			int n = reader.nextInt(), m = reader.nextInt();
			
			if(n == 0 && m == 0) break;
			
			ArrayList<Node> graph = new ArrayList<Node>(n);
			
			for(int i = 0; i < n; i++){
				graph.add(i, new Node(i));
			}
			
			
			for(int i = 0; i < m; i++){
				int a = reader.nextInt(), b = reader.nextInt();
				
				graph.get(a).edges.add(new Edge(b));
				graph.get(b).edges.add(new Edge(a));
			}
			
			int max = 0;
			for(int i = 0; i < n; i++){
				int test = getMax(graph, i);
				if(test > max) max = test;
			}
			
			System.out.println(max);
		}
		
	}
	
	static int getMax(ArrayList<Node> graph, int start){
		int max = 0;
		
		Node n = graph.get(start);
		ArrayList<Edge> edges = n.edges;
		
		for(int i = 0; i < edges.size(); i++){
			Edge e = edges.get(i);
			if(e.used) continue;
			Node d = graph.get(e.dest);
			
			e.used = true;
			for(int j = 0; j < d.edges.size(); j++){
				if (d.edges.get(j).dest == start){
					d.edges.get(j).used = true;
					break;
				}
			}
			int test = 1 + getMax(graph, e.dest);
			if(test > max) max = test;
			e.used = false;
			for(int j = 0; j < d.edges.size(); j++){
				if (d.edges.get(j).dest == start){
					d.edges.get(j).used = false;
					break;
				}
			}
		}
		
		return max;
	}
}
