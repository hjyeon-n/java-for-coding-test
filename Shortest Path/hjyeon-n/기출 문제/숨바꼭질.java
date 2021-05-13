import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Node>[] graph;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 28분
		//		체감 난이도 : 골드 5

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		dist = new int[N + 1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph[x].add(new Node(y, 1));
			graph[y].add(new Node(x, 1));
		}
		
		dijkstra();
		
		int idx = N + 1;
		int answer = -1;
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (answer <= dist[i]) {
				if (answer == dist[i]) {
					cnt++;
				}
				else {
					idx = i;
				}
				answer = dist[i];
			}
		}
		
		System.out.println(idx + " " + answer + " " + cnt);
	}
	
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> (a.w - b.w));
		pq.add(new Node(1, 0));
		dist[1] = 0;
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int v = node.v;
			int w = node.w;
			
			if (dist[v] < w) {
				continue;
			}
			
			for (int i = 0; i < graph[v].size(); i++) {
				int nv = graph[v].get(i).v;
				int nw = graph[v].get(i).w;
				
				if (dist[v] + nw < dist[nv]) {
					dist[nv] = dist[v] + nw;
					pq.add(new Node(nv, dist[nv]));
				}
			}
		}
	}
}

class Node {
	int v, w;
	
	public Node (int v, int w) {
		this.v = v;
		this.w = w;
	}
}