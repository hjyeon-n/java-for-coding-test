import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		�ҿ� �ð� : 14��
		//		ü�� ���̵� : �ǹ�5

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int zero = 0;
		int one = 0;

		int prev = str.charAt(0) - '0';
		
		if (prev == 1) {
			zero++;
		}
		else {
			one++;
		}
		
		for (int i = 0; i < str.length() - 1; i++) {
			int n1 = str.charAt(i) - '0';
			int n2 = str.charAt(i + 1) - '0'; 
			if(n1 != n2) {
				if (n2 == 0) {
					one++;
				}
				else {
					zero++;
				}
			}
		}

		System.out.println(Math.min(one, zero));
	}	
}