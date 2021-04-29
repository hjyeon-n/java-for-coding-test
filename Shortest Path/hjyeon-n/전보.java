import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Node>[] graph;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 28분
		//		체감 난이도 : 골드 5
		//		★★★★★

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		dist = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Node>();
			dist[i] = 987654321;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int Z = Integer.parseInt(st.nextToken());
			
			graph[X].add(new Node(Y, Z));
		}
		
		dijkstra(C);
		
		int cnt = 0;
		int time = 0;
		
		for (int i = 1; i <= N; i++) {
			if (dist[i] != 987654321) {
				cnt++;
				time = Math.max(time, dist[i]);
			}
		}
		
		System.out.println((cnt - 1) + " " + time);
	}
	
	public static void dijkstra(int x) {
		dist[x] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> (a.d - b.d));
		pq.add(new Node(x, 0));
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			
			int now = node.val;
			int distance = node.d;
			
			if (dist[now] < distance) {
				continue;
			}
			
			for (Node v : graph[now]) {
				if (dist[now] + v.d < dist[v.val]) {
					dist[v.val] = dist[now] + v.d;
					pq.add(new Node(v.val, dist[v.val]));
				}
			}
		}
	}
}

class Node {
	int val;
	int d;
	
	public Node (int val, int d) {
		this.val = val;
		this.d = d;
	}
}