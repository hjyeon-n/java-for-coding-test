import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 18분
		//		체감 난이도 : 실버 2
		//		★★★★★		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		
		int[][] map = new int[A.length() + 1][B.length() + 1];
		
		for (int i = 1; i <= B.length(); i++) {
			map[0][i] = i;
		}
		
		for (int i = 1; i <= A.length(); i++) {
			map[i][0] = i;
		}
		
		for (int i = 1; i <= A.length(); i++) {
			for (int j = 1; j <= B.length(); j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					map[i][j] = map[i - 1][j - 1];
				}
				else {
					map[i][j] = Math.min(map[i - 1][j - 1], Math.min(map[i - 1][j], map[i][j - 1])) + 1;
				}
			}
		}
		
		System.out.println(map[A.length()][B.length()]);
	}
}