import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, C;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 55분
		//		체감 난이도 : 실버 1

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		binarySearch();
	}
	
	public static void binarySearch() {
		int s = 1;
		int e = arr[N - 1] - arr[0];
		int rslt = 0;
		
		while (s <= e) {
			int mid = (s + e) / 2;
			int val = arr[0];
			int cnt = 1;
			
			for (int i = 1; i < N; i++) {
				if (val + mid <= arr[i]) {
					cnt++;
					val = arr[i];
				}
			}
			
			if (cnt >= C) {
				s = mid + 1;
				rslt = mid;
			}
			else {
				e = mid - 1;
			}
		}
		
		System.out.println(rslt);
	}
}