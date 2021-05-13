import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 10분
		//		체감 난이도 : 실버 1

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			pq.add(num);
		}
		
		if (N == 1) {
			System.out.println(0);
			return;
		}
		
		int sum = 0;
		int rslt = 0;
		
		while (!pq.isEmpty()) {
			int n1 = pq.poll();
			int n2 = pq.poll();
			sum = n1 + n2;
			rslt += sum;
			
			if (!pq.isEmpty()) {
				pq.add(sum);
			}
		}
		
		System.out.println(rslt);
	}
}