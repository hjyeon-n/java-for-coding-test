import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		소요 시간 : 9분
//		체감 난이도 : 실버2
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] part = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			part[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(part);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			int need = Integer.parseInt(st.nextToken());
			
			if (search(need, part) == 1) {
				sb.append("yes" + " ");
			}
			else {
				sb.append("no" + " ");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static int search(int num, int[] part) {
		int s = 0;
		int e = part.length - 1;
		
		while (s <= e) {
			int mid = (s + e) / 2;
			
			if (part[mid] == num) {
				return 1;
			}
			else if (part[mid] < mid) {
				e = mid - 1;
			}
			else {
				s = mid + 1;
			}
		}
		
		return -1;
	}
}