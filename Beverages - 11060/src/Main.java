import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static class Vertex{
		String name;
		ArrayList<Edge> edges = new ArrayList<Edge>();
		
		public Vertex(String name){
			this.name = name;
		}
	}
	
	static class Edge{
		String dest;
		
		public Edge(String dest){
			this.dest = dest;
		}
	}
	
	static ArrayList<Vertex> graph;
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		int count = 0;
		while(reader.hasNext()){
			count++;
			graph = new ArrayList<Vertex>();
			
			int N = reader.nextInt();
			reader.nextLine();
			for(int i = 0; i < N; i++){
				String str = reader.nextLine();
				graph.add(new Vertex(str));
			}
			
			int M = reader.nextInt();
			reader.nextLine();
			for(int i = 0; i < M; i++){
				String b1 = reader.nextLine();
				String b2 = reader.nextLine();
				graph.get(graph.indexOf(new Vertex(b1))).edges.add(new Edge(b2));
			}
		}
	}

}
