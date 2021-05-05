import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int target = 0;
		int answer = 0;
		while (true) {
			target = (N / K) * K;
			answer += (N - target);
			N = target;
			
			if (N < K) {
				break;
			}
			
			N /= K;
			answer+= 1;
		}
		
		answer += N - 1;
		System.out.println(answer);
	}
}