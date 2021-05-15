import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 18분
		//		체감 난이도 : 실버 2

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < A.length(); i++) {
			char alpha = A.charAt(i);
			
			if (map.containsKey(alpha)) {
				map.put(alpha, map.get(alpha) + 1);
			}
			else {
				map.put(alpha, 1);
			}
		}
		
		int answer = 0;
		for (int i = 0; i < B.length(); i++) {
			char alpha = B.charAt(i);
			
			if (map.containsKey(alpha)) {
				if (map.get(alpha) > 0) {
					map.put(alpha, map.get(alpha) - 1);
				}
				else {
					answer++;
				}
			}
			else {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}