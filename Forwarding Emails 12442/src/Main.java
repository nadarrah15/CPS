import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[] graph, sum;
	static boolean[] visited;
	static int count;
	
	static int dfs(int v){
		visited[v] = true;
		
		int w = 0;
		if(!visited[graph[v]]){
			w += 1 + dfs(graph[v]);
		}
		visited[v] = false;
		sum[v] = w;
		return w;
	}
	
	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		
		int T = reader.nextInt();
		for(int Case = 1; Case <= T; Case++){
			int N = reader.nextInt();
			graph = new int[N];
			sum = new int[N];
			Arrays.fill(sum, -1);
			visited = new boolean[N];
			
			for(int i = 0; i < N; i++){
				int u = reader.nextInt(), v = reader.nextInt();
				graph[u - 1] = v - 1;
			}
			
			int max = 0, point = 0;
			for(int i = 0; i < N; i++){
				if(sum[i] == -1) dfs(i);
				if(sum[i] > max){
					max = sum[i];
					point = i + 1;
				}
			}
			
			System.out.println("Case " + Case + ": " + point);
		}
	}
}