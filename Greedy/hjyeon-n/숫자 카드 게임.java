import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		소요시간 : 6분
//		체감 난이도 : 브론즈 4
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			int min = 10000;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				min = Math.min(min, Integer.parseInt(st.nextToken()));
			}
			
			max = Math.max(max, min);
		}
		
		System.out.println(max);
	}
}