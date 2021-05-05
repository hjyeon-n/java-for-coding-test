import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 5분
		//		체감 난이도 : 브론즈3

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int answer = str.charAt(0) - '0';
		
		for (int i = 1; i < str.length(); i++) {
			int n = str.charAt(i) - '0';
			if (n <= 1 || answer <= 1) {
				answer += n;
			}
			else {
				answer *= n;
			}
		}
		
		System.out.println(answer);
	}	
}