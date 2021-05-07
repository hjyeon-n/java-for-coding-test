import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 19분
		//		체감 난이도 : 실버1

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int[][] map = new int[n][n];
 		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < i + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
 		
 		for (int i = 1; i < n; i++) {
 			for (int j = 0; j <= i; j++) {
 				if (j == 0) {
 					map[i][j] += map[i - 1][j];
 				}
 				else if (i == j) {
 					map[i][j] += map[i - 1][j - 1];
 				}
 				else {
 					map[i][j] += Math.max(map[i - 1][j - 1], map[i - 1][j]);
 				}
 			}
 		}
 		
 		int max = -1;
 		for (int i = 0; i < n; i++) {
 			max = Math.max(max, map[n - 1][i]);
 		}
 		
 		System.out.println(max);
	}
}