import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 40분
		//		체감 난이도 : 골드 5
		//		★★★★★			

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		
		arr = new int[G + 1];
		for (int i = 1; i <= G; i++) {
			arr[i] = i;
		}
		
		int answer = 0;
		for (int i = 0; i < P; i++) {
			int v = Integer.parseInt(br.readLine());
			int root = find(v);
			
			if (root == 0) {
				break;
			}
			
			union(root, root - 1);
			answer += 1;
		}
		
		System.out.println(answer);
	}
	
	public static int find(int v) {
		if (arr[v] == v) {
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
		
		if (v1 < v2){
			arr[v2] = v1;
		}
	}
}