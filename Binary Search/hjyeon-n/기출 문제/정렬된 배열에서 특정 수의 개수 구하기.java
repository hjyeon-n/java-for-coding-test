import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 15분
		//		체감 난이도 : 실버 2

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int lower = lowerBound(N, M);
		int upper = upperBound(N, M);
		
		if (upper - lower > 0) {
			System.out.println(upper - lower);
		}
		else {
			System.out.println(-1);
		}
	}
	
	public static int lowerBound(int N, int target) {
		int s = 0;
		int e = N - 1;
		
		while (s < e) {
			int mid = (s + e) / 2;
			
			if (arr[mid] >= target) {
				e = mid;
			}
			else {
				s = mid + 1;
			}
		}
		
		return e;
	}
	
	public static int upperBound(int N, int target) {
		int s = 0;
		int e = N - 1;
		
		while (s < e) {
			int mid = (s + e) / 2;
			
			if (arr[mid] <= target) {
				s = mid + 1;
			}
			else {
				e = mid;
			}
		}
		return e;
	}
}