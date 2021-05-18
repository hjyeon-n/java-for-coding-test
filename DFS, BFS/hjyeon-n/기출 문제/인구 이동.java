import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, L, R, sum;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Location> list;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 10분
		//		체감 난이도 : 실버 1

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		while (true) {
			visited = new boolean[N][N];
			sum = 0;
			int stop = 0;

			//			인접한 나라와 인구 차이를 알아보기 위해서 BFS

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						list = new ArrayList<Location>();
						bfs(i, j);
						int val = sum / list.size();
						for (Location loc : list) {
							map[loc.x][loc.y] = val;
						}
						stop++;
					}
				}
			}

			if (stop == N * N) {
				break;
			}
			
			cnt++;
		}

		System.out.println(cnt);
	}

	public static void bfs(int bfs_x, int bfs_y) {
		Queue<Location> queue = new LinkedList<Location>();
		queue.add(new Location(bfs_x, bfs_y));
		sum = map[bfs_x][bfs_y];
		list.add(new Location(bfs_x, bfs_y));
		visited[bfs_x][bfs_y] = true;

		while (!queue.isEmpty()) {
			Location loc = queue.poll();
			int x = loc.x;
			int y = loc.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					int condition = Math.abs(map[nx][ny] - map[x][y]);
					if (!visited[nx][ny] && condition >= L && condition <= R) {
						list.add(new Location(nx, ny));
						sum += map[nx][ny];
						visited[nx][ny] = true;
						queue.add(new Location(nx, ny));
					}
				}
			}
		}
	}
}

class Location {
	int x, y;

	public Location (int x, int y) {
		this.x = x;
		this.y = y;
	}
}