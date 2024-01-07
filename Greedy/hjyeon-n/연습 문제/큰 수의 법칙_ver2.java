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
		
		System.out.println(solution(N, M, K, arr));
	}
	
	public static int solution(int N, int M, int K, int[] arr) {
		int result = 0;
		
		Arrays.sort(arr);
		
		int val = M / (K + 1);
		int add = M % (K + 1);
		
		result = (arr[N - 1] * K + arr[N - 2]) * val + arr[N - 1] * add;
		
		return result;
	}
}