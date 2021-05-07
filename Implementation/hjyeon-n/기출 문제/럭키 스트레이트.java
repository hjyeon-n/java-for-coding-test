import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 3분
		//		체감 난이도 : 브론즈4

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length() / 2;
		
		int left = 0;
		for (int i = 0; i < len; i++) {
			left += str.charAt(i) - '0';
		}
		
		int right = 0;
		for (int i = len; i < str.length(); i++) {
			right += str.charAt(i) - '0';
		}
		
		if (left == right) {
			System.out.println("LUCKY");
		}
		else {
			System.out.println("READY");
		}
	}	
}