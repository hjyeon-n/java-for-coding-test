import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int idx = N - 1;
		int sum = 0;
		while (true) {
			if (M == 0) {
				break;
			}
			
			if (M / K >= 1) {
				M -= K;
				for (int i = 0; i < K; i++) {
					sum += arr[idx];
				}
			}
			else {
				M -= M % K;
				for (int i = 0; i < M % K; i++) {
					sum += arr[idx];
				}
			}
			
			sum += arr[idx - 1];
			M -= 1;
		}
		
		System.out.println(sum);
	}
}