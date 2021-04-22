import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N, M;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		소요 시간 : 2분
//		체감 난이도 : 실버1
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					answer++;
					dfs(i, j);
				}
			}
		}
		
		System.out.println(answer);
	}
	
	public static void dfs(int dfs_x, int dfs_y) {
		visited[dfs_x][dfs_y] = true; 
		
		for (int i = 0; i < 4; i++) {
			int nx = dfs_x + dx[i];
			int ny = dfs_y + dy[i];
			
			if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
				if (map[nx][ny] == 0 && !visited[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}
}