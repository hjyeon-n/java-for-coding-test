import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int N, M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		소요 시간 : 18분
//		체감 난이도 : 실버1
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		int max = -1;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		Arrays.sort(arr);
		System.out.println(setHeight(M, max));
	}
	
	public static int setHeight(int M, int max) {
		int s = 0;
		int e = max;
		int answer = 0;
		
		while (s <= e) {
			int mid = (s + e) / 2;
			int rslt = cal(mid);
			
			if (rslt < M) {
				e = mid - 1;
			}
			else {
				answer = mid;
				s = mid + 1;
			}
		}
		
		return answer;
	}
	
	public static int cal(int h) {
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			if (arr[i] > h) {
				sum += arr[i] - h;
			}
		}
		
		return sum;
	}
}