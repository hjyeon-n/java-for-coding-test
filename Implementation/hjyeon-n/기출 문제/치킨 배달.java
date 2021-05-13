import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int answer;
	static boolean[] visited;
	static int[] arr;
	static int[][] map;
	static ArrayList<Node> chicken;
	static ArrayList<Node> home;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 29분
		//		체감 난이도 : 실버 1

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][N + 1];
		chicken = new ArrayList<Node>();
		home = new ArrayList<Node>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 1) {
					home.add(new Node(i, j));
				}
				
				if (map[i][j] == 2) {
					chicken.add(new Node(i, j));
				}
			}
		}
		
		arr = new int[M];
		visited = new boolean[chicken.size()];
		answer = Integer.MAX_VALUE;
		comb(chicken.size(), M, 0, 0);
		
		System.out.println(answer);
	}
	
	public static void comb(int N, int M, int depth, int idx) {
		if (depth == M) {
			int sum = 0;
			
			for (int i = 0; i < home.size(); i++) {
				int min = Integer.MAX_VALUE;
				Node home_loc = home.get(i);
				int home_x = home_loc.x;
				int home_y = home_loc.y;
				
				for (int j = 0; j < M; j++) {
					Node chicken_loc = chicken.get(arr[j] - 1);
					int chicken_x = chicken_loc.x;
					int chicken_y = chicken_loc.y;
					
					int d = Math.abs(chicken_x - home_x) + Math.abs(chicken_y - home_y);
					min = Math.min(min, d);
				}
				sum += min;
			}
			
			answer = Math.min(answer, sum);
			return;
		}
		
		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i + 1;
				comb(N, M, depth + 1, i);
				visited[i] = false;
			}
		}
	}
}

class Node {
	int x, y;
	
	public Node (int x, int y) {
		this.x = x;
		this.y = y;
	}
}