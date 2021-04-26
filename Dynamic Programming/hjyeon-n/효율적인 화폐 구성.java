import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 
		//		체감 난이도 : 실버1
		//		★★★★★

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int[] dp = new int[M + 1];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 1; i <= M; i++) {
			dp[i] = 100001;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = arr[i]; j <= M; j++) {
				dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
			}
		}

		if (dp[M] == -1) {
			System.out.println(-1);
		}
		else {
			System.out.println(dp[M]);
		}
	}
}