import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		�ҿ� �ð� : 25��
		//		ü�� ���̵� : �ǹ� 1
		//		�ڡڡڡڡ�		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] t = new int[15]; // �� ����� �Ϸ��ϴµ� �ɸ��� �Ⱓ
	    int[] p = new int[15]; // �� ����� �Ϸ����� �� ���� �� �ִ� �ݾ�
	    int[] dp = new int[16]; // ���̳��� ���α׷����� ���� 1���� DP ���̺� �ʱ�ȭ
		
	    for (int i = 0; i < N; i++) {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	t[i] = Integer.parseInt(st.nextToken());
	    	p[i] = Integer.parseInt(st.nextToken());
	    }
	    
		for (int i = N - 1; i >= 0; i--) {
			int time = t[i] + i;
			
			 // ����� �Ⱓ �ȿ� ������ ���
			if (time <= N) {
				// ��ȭ�Ŀ� �°�, ��������� �ְ� ���� ���
				dp[i] = Math.max(p[i] + dp[time], dp[i + 1]);
			}
			// ����� �Ⱓ�� ����� ���
			else {
				dp[i] = dp[i + 1];
			}
		}
		
		System.out.println(dp[1]);
	}
}