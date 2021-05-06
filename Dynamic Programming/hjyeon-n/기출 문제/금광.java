import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 35분
		//		체감 난이도 : 실버2

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			int[][] map = new int[n + 1][m + 1];
			
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= m; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = -1;
			for (int k = 2; k <= m; k++) {
				for (int j = 1; j <= n; j++) {
					if (j == 1) {
						map[j][k] += Math.max(map[j][k - 1], map[j + 1][k - 1]);
					}
					else if (j == n) {
						map[j][k] += Math.max(map[j][k - 1], map[j - 1][k - 1]);
					}
					else {
						map[j][k] += Math.max(map[j][k - 1], Math.max(map[j + 1][k - 1], map[j - 1][k - 1]));
					}
					
					max = Math.max(max, map[j][k]);
				}
			}
			
			sb.append(max + "\n");
		}
		
		System.out.print(sb.toString());
	}
}