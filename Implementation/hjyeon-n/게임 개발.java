import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N, M;
	static int x, y, d, answer;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		소요 시간 : 1시간
//		체감 난이도 : 실버1
//		교재 문제 정의가 명확하지 않아서 issue 답변을 참고해서 풀어야 함
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		visited[x][y] = true;
		answer = 1;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (true) {
//			방향 지정
			setDirection();
			
//			왼쪽에 아직 방문하지 않은 곳이 있는지 확인
			if (notVisited(d)) {
				continue;
			}

//				네 방향 확인
			if (allVisited()) {
				int nd = (d + 2) % 4;
				if (!step(nd)) {
					break;
				}
				else {
					continue;
				}
			}
		}
		
		System.out.println(answer);
	}
	
	public static void setDirection() {
		if (d == 0) {
			d = 3;
		}
		else {
			d -= 1;
		}
	}
	
	public static boolean notVisited(int nd) {
		int nx = dx[nd] + x;
		int ny = dy[nd] + y;
		
		if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
			if (!visited[nx][ny] && map[nx][ny] == 0) {
				visited[nx][ny] = true;
				x = nx;
				y = ny;
				answer++;
				return true;
 			}
		}
		return false;
	}
	
	public static boolean step(int nd) {
		int nx = dx[nd] + x;
		int ny = dy[nd] + y;
		
		if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
			if (map[nx][ny] == 0) {
				x = nx;
				y = ny;
				return true;
 			}
		}
		return false;
	}
	
	public static boolean allVisited() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 1 && nx <= N && ny >= 1 && ny <= M) {
					if (map[nx][ny] == 0 && !visited[nx][ny]) {
						return false;
					}
				}
			}
		}
		return true;
	}
}