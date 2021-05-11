import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] bucket;
	static boolean[] visited;
	static int answer;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 23분
		//		체감 난이도 : 실버 2

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		bucket = new int[2];
		visited = new boolean[N];
		answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(N, 2, 0, 0);
		
		System.out.println(answer);
	}
	
	public static void comb(int N, int M, int depth, int idx) {
		if (depth == M) {
			if (arr[bucket[0]] != arr[bucket[1]]) {
				answer++;
			}
			return;
		}
		
		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				bucket[depth] = i;
				comb(N, M, depth + 1, i);
				visited[i] = false;
			}
		}
	}
} 