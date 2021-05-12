import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 25분
		//		체감 난이도 : 실버 1
		//		★★★★★		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] t = new int[15]; // 각 상담을 완료하는데 걸리는 기간
	    int[] p = new int[15]; // 각 상담을 완료했을 때 받을 수 있는 금액
	    int[] dp = new int[16]; // 다이나믹 프로그래밍을 위한 1차원 DP 테이블 초기화
		
	    for (int i = 0; i < N; i++) {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	t[i] = Integer.parseInt(st.nextToken());
	    	p[i] = Integer.parseInt(st.nextToken());
	    }
	    
		for (int i = N - 1; i >= 0; i--) {
			int time = t[i] + i;
			
			 // 상담이 기간 안에 끝나는 경우
			if (time <= N) {
				// 점화식에 맞게, 현재까지의 최고 이익 계산
				dp[i] = Math.max(p[i] + dp[time], dp[i + 1]);
			}
			// 상담이 기간을 벗어나는 경우
			else {
				dp[i] = dp[i + 1];
			}
		}
		
		System.out.println(dp[1]);
	}
}