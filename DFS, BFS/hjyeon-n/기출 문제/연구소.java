import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, answer;
	static int[] arr;
	static int[][] map, copy;
	static boolean[][] visited;
	static boolean[] picked;
	static ArrayList<Location> list, virus;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 50분
		//		체감 난이도 : 골드5

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		copy = new int[N][M];
		visited = new boolean[N][M];
		list = new ArrayList<Location>();
		virus = new ArrayList<Location>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 0) {
					list.add(new Location(i, j));
				}
				
				if (map[i][j] == 2) {
					virus.add(new Location(i, j));
				}
			}
		}
		
		answer = 0;
		arr = new int[3];
		picked = new boolean[list.size()];
		comb(list.size(), 0, 0);
		
		System.out.println(answer);
	}	
	
	public static void comb(int all, int depth, int idx) {
		if (depth == 3) {
			deepCopy();
			for (int i = 0; i < 3; i++) {
				Location loc = list.get(arr[i]);
				copy[loc.x][loc.y] = 1;
			}
			bfs();
			answer = Math.max(answer, check());
			return;
		}
		
		for (int i = idx; i < all; i++) {
			if (!picked[i]) {
				picked[i] = true;
				arr[depth] = i;
				comb(all, depth + 1, i);
				picked[i] = false;
			}
		}
	}
	
	public static void deepCopy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = map[i][j];
				visited[i][j] = false;
			}
		}
	}
	
	public static void bfs() {
		Queue<Location> queue = new LinkedList<Location>();
		for (Location loc : virus) {
			queue.add(loc);
			visited[loc.x][loc.y] = true;
		}
		
		while (!queue.isEmpty()) {
			Location loc = queue.poll();
			int x = loc.x;
			int y = loc.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (!visited[nx][ny] && copy[nx][ny] == 0) {
						visited[nx][ny] = true;
						copy[nx][ny] = 2;
						queue.add(new Location(nx, ny));
					}
				}
			}
		}
	}
	
	public static int check() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}
}

class Location {
	int x, y;
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}