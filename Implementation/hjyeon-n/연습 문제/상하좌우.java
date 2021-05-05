import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		소요 시간 : 8분
//		체감 난이도 : 브론즈 2
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		N 입력 받기
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = 1;
		int y = 1;
		
//		이동 계획 길이만큼 명령어 확인
		while (st.hasMoreElements()) {
			String command = st.nextToken();
			
//			범위 확인 후 이동
			if (command.equals("L")) {
				if (y - 1 >= 1) {
					y -= 1;
				}
			}
			else if (command.equals("R")) {
				if (y + 1 <= N) {
					y += 1;
				}
			}
			else if (command.equals("U")) {
				if (x - 1 >= 1) {
					x -= 1;
				}
			}
			else {
				if (x + 1 <= N) {
					x += 1;
				}
			}
		}
		
		System.out.println(x + " " + y);
	}
}