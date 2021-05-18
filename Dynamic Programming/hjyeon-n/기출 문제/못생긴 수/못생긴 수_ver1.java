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
		
		if (N == 1) {
			System.out.println("1");
			return;
		}
		
		int[] dp = new int[N + 1];
		dp[1] = 1;
		
		int cnt = 2;
		int idx = 2;
		while (idx != N + 1) {
			if (isNum(cnt)) {
				dp[idx++] = cnt;
			}
			cnt++;
		}
		
		System.out.println(dp[N]);
	}
	
	public static boolean isNum(int num) {
		while (num > 1) {
			if (num % 2 == 0) {
				num /= 2;
			}
			else if (num % 3 == 0) {
				num /= 3;
			}
			else if (num % 5 == 0) {
				num /= 5;
			}
			else {
				return false;
			}
		}
		return true;
	}
}