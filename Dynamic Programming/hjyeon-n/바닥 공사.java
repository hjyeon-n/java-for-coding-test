import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		�ҿ� �ð� : 10��
		//		ü�� ���̵� : �ǹ�1
		//		�ڡڡڡڡ�

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];

		dp[1] = 1;
		dp[2] = 3;

		for (int i = 3; i <= N; i++) {
			dp[i] = (2 * dp[i - 2] + dp[i - 1]) % 796796;
		}

		System.out.println(dp[N]);
	}
}