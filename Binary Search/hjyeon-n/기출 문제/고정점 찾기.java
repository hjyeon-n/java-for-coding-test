import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static int answer;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 10분
		//		체감 난이도 : 실버 3

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		answer = -1;
		binarySearch();
		System.out.println(answer);
	}
	
	public static void binarySearch() {
		int s = 0;
		int e = N - 1;
		
		while (s <= e) {
			int mid = (s + e) / 2;
			
			if (arr[mid] == mid) {
				answer = mid;
				break;
			}
			else if (arr[mid] > mid) {
				e = mid - 1;
			}
			else {
				s = mid + 1;
			}
		}
	}
}