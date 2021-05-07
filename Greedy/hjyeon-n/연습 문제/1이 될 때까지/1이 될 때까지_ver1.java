import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		�ҿ�ð� : 2��
//		ü�� ���̵� : ����� 5
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		while (N != 1) {
			if (N % K == 0) {
				N /= K;
				answer++;
			}
			else {
				N -= 1;
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}