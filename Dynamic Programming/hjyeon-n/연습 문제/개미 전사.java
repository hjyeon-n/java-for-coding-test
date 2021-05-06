import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 8분
		//		체감 난이도 : 실버2
		//		★★★★★

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		dp[1] = Math.max(dp[0], arr[1]);

		for (int i = 2; i <= N; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
		}

		System.out.println(dp[N]);
	}
}