import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, X;
	static ArrayList<ArrayList<Integer>> map;
	static int[] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 29분
		//		체감 난이도 : 실버2

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		map = new ArrayList<ArrayList<Integer>>();
		visited = new int[N + 1];
		
		for (int i = 0; i <= N; i++) {
			map.add(new ArrayList<Integer>());
			visited[i] = -1;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map.get(a).add(b);
		}
		
		bfs();
		
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (visited[i] == K) {
				cnt++;
				sb.append(i + "\n");
			}
		}
		
		if (cnt == 0) {
			System.out.println("-1");
		}
		else {
			System.out.println(sb.toString());
		}
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(X);
		visited[X] = 0;
		
		while (!queue.isEmpty()) {
			int node = queue.poll();
			
			for (int i = 0; i < map.get(node).size(); i++) {
				int newNode = map.get(node).get(i);
				if (visited[newNode] == -1) {
					visited[newNode] = visited[node] + 1;
					queue.add(newNode);
				}
			}
		}
	}
}

class Location {
	int x, y;
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}