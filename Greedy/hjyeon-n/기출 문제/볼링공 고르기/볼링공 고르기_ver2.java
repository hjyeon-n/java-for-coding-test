import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 23분
		//		체감 난이도 : 실버 2

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			int idx = Integer.parseInt(st.nextToken());
			arr[idx] += 1;
		}
		
		int answer = 0;
		for (int i = 1; i <= M; i++) {
			N -= arr[i];
			answer += arr[i] * N;
		}
		
		System.out.println(answer);
	}
} 