import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 14분
		//		체감 난이도 : 실버5

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int zero = -1;
		int one = -1;

		int prev = str.charAt(0) - '0';
		for (int i = 1; i < str.length(); i++) {
			int n = str.charAt(i) - '0';
			if(n != prev) {
				if (n == 0) {
					one++;
				}
				else {
					zero++;
				}
			}
		}

		int answer = 0;
		if (zero != -1 && one != -1) {
			answer = Math.min(zero, one);
		}
		else if (zero == -1) {
			answer = one;
		}
		else if (one == -1) {
			answer = zero;
		}
		
		System.out.println(answer);
	}	
}