import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[][] visited;
	static int N, M;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		소요 시간 : 9분
//		체감 난이도 : 실버1
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][M + 1];
		visited = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j - 1) - '0';
			}
		}
		
		bfs(1, 1);
		
		System.out.println(visited[N][M]);
	}
	
	public static void bfs(int bfs_x, int bfs_b) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(bfs_x, bfs_b));
		visited[bfs_x][bfs_b] = 1;
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.x;
			int y = node.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 1 && nx <= N && ny >= 1 && ny <= M) {
					if (map[nx][ny] == 1 && visited[nx][ny] == 0) {
						visited[nx][ny] = visited[x][y] + 1;
						queue.add(new Node(nx, ny));
					}
				}
			}
		}
	}
}

class Node {
	int x;
	int y;
	
	public Node (int x, int y) {
		this.x = x;
		this.y = y;
	}
}