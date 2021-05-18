import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] graph;
	static int[][] dist;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 13분
		//		체감 난이도 : 실버 3

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			graph = new int[N][N];
			dist = new int[N][N];
			
			for (int a = 0; a < N; a++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int b = 0; b < N; b++) {
					graph[a][b] = Integer.parseInt(st.nextToken());
					dist[a][b] = Integer.MAX_VALUE;
				}
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> (a.w - b.w));
			pq.offer(new Node(0, 0, graph[0][0]));
			dist[0][0] = graph[0][0];
			
			while (!pq.isEmpty()) {
				Node node = pq.poll();
				int x = node.x;
				int y = node.y;
				int w = node.w;
				
				if (dist[x][y] < w) {
					continue;
				}
				
				for (int k = 0; k < 4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];
					
					if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
						int cost = graph[nx][ny] + w;
						
						if (cost < dist[nx][ny]) {
							dist[nx][ny] = cost;
							pq.add(new Node(nx, ny, cost));
						}
					}
				}
			}
			
			sb.append(dist[N - 1][N - 1] + "\n");
		}
		
		System.out.println(sb.toString());
	}
}

class Node {
	int x, y, w;
	
	public Node(int x, int y, int w) {
		this.x = x;
		this.y = y;
		this.w = w;
	}
}