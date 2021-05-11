import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	static int[][] map;
	static int N, K, S, X, Y;
	static ArrayList<Node> list;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 16분
		//		체감 난이도 : 실버 1

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][N + 1];
		list = new ArrayList<Node>();
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] != 0) {
					list.add(new Node(i, j, map[i][j], 0));
				}
			}
		}
		
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.v - o2.v;
			}
		});
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		spread();
	}
	
	public static void spread() {
		Queue<Node> queue = new LinkedList<Node>();
		
		for (Node node : list) {
			queue.add(node);
		}
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.x;
			int y = node.y;
			int v = node.v;
			int t = node.t;
			
			if (t == S) {
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
					if (map[nx][ny] == 0) {
						map[nx][ny] = v;
						queue.add(new Node(nx, ny, v, t + 1));
					}
				}
			}
		}
		
		System.out.println(map[X][Y]);
	}
}

class Node {
	int x, y, v, t;
	public Node (int x, int y, int v, int t) {
		this.x = x;
		this.y = y;
		this.v = v;
		this.t = t;
	}
}