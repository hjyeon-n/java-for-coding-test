import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 13분
		//		체감 난이도 : 실버 3

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		// 2배, 3배, 5배를 위한 인덱스
		int i2 = 1, i3 = 1, i5 = 1;
		// 처음에 곱셈 값을 초기화
		int next2 = 2, next3 = 3, next5 = 5;

		int[] dp = new int[N + 1];
		dp[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			dp[i] = Math.min(next2, Math.min(next3, next5));
			
			if (dp[i] == next2) {
				i2++;
				next2 = dp[i2] * 2;
			}
			if (dp[i] == next3) {
				i3++;
				next3 = dp[i3] * 3;
			}
			if (dp[i] == next5) {
				i5++;
				next5 = dp[i5] * 5;
			}
		}

		System.out.println(dp[N]);
	}
}