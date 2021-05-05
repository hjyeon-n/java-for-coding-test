import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 6분
		//		체감 난이도 : 브론즈2

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		ArrayList<Character> list = new ArrayList<Character>();
		int sum = 0;
		
		for (int i = 0; i < str.length(); i++) {
			char alpha = str.charAt(i);
			
			if (alpha - '0' >= 0 && alpha - '0' <= 9) {
				sum += alpha - '0';
			}
			else {
				list.add(alpha);
			}
		}
		
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for (char alpha : list) {
			sb.append(alpha);
		}
		sb.append(sum);
		
		System.out.println(sb.toString());
	}	
}