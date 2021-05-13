import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int[] num;
	static String[] arr;
	static String[] bucket;
	static int max, min;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 30분
		//		체감 난이도 : 실버 1

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new String[N - 1];
		bucket = new String[N - 1];
		visited = new boolean[N - 1];
		num = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		String[] operand = {"+", "-", "*", "/"};
		st = new StringTokenizer(br.readLine());
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			int cnt = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < cnt; j++) {
				arr[idx++] = operand[i];
			}
		}
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		comb(N - 1, N - 1, 0, 0);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void comb(int N, int M, int depth, int idx) {
		if (depth == M) {
			int rslt = num[0];
			for (int i = 0; i < N; i++) {
				if (bucket[i].equals("+")) {
					rslt += num[i + 1];
				}
				else if (bucket[i].equals("-")) {
					rslt -= num[i + 1];
				}
				else if (bucket[i].equals("*")) {
					rslt *= num[i + 1];
				}
				else {
					boolean flag = false;
					if (rslt < 0) {
						flag = true;
						rslt *= -1;
					}
					rslt /= num[i + 1];
					
					if (flag) {
						rslt *= -1;
					}
				}
			}
			
			max = Math.max(rslt, max);
			min = Math.min(rslt, min);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				bucket[depth] = arr[i];
				comb(N, M, depth + 1, i);
				visited[i] = false;
			}
		}
	}
}