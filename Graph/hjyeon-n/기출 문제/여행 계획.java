import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int N, M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 24분
		//		체감 난이도 : 골드 5

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				if (num == 1) {
					if (find(i) != find(j)) {
						union(i, j);
					}
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		String answer = "YES";
		
		for (int i = 0; i < M - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				answer = "NO";
				break;
			}
		}
		
		System.out.println(answer);
	}
	
	public static int find(int v) {
		if (v == arr[v]) {
			return v;
		}
		return arr[v] = find(arr[v]);
	}
	
	public static void union(int v1, int v2) {
		v1 = find(v1);
		v2 = find(v2);
		
		if (v1 > v2) {
			arr[v1] = v2;
		}
		else {
			arr[v2] = v1;
		}
	}
}