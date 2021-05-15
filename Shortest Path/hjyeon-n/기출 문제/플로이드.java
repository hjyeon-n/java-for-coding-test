import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 15분
		//		체감 난이도 : 실버 1

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					map[i][j] = 0;
				}
				else {
					map[i][j] = 987654321;
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			map[x][y] = Math.min(map[x][y], w);
		}
		
		for (int i = 1; i <= N; i++) {
			for (int a = 1; a <= N; a++) {
				for (int b = 1; b <= N; b++) {
					map[a][b] = Math.min(map[a][b], map[a][i] + map[i][b]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 987654321) {
					sb.append(0 + " ");
				}
				else {
					sb.append(map[i][j] + " ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}