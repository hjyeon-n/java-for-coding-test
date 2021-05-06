import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 10분
		//		체감 난이도 : 골드 5
		//		★★★★★

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (command == 0) {
				union(a, b);
			}
			else {
				if (find(a) == find(b)) {
					sb.append("YES" + "\n");
				}
				else {
					sb.append("NO" + "\n");
				}
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static int find(int x) {
		if (x == arr[x]) {
			return x;
		}
		
		return arr[x] = find(arr[x]);
	}
	
	public static void union(int v1, int v2) {
		v1 = find(v1);
		v2 = find(v2);
		
		if (v1 < v2) {
			arr[v2] = v1;
		}
		else {
			arr[v1] = v2;
		}
	}
}