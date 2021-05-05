import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		소요 시간 : 12분
//		체감 난이도 : 실버4
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String loc = br.readLine();
		
//		x와 y값 입력
		int y = loc.charAt(0) - 97;
		int x = Integer.parseInt(loc.substring(1));
		
//		나이트 이동 가능 좌표
		int[] dx = {-2, 2, -1, 1};
		int[] dy = {-2, 2, -1, 1};
		
		int answer = 0;
		for (int i = 0; i < 2; i++) {
			if (x + dx[i] >= 1 && x +dx[i] <= 8) {
				for (int j = 2; j < 4; j++) {
					if (y + dy[j] >= 1 && y + dy[j] <= 8) {
						answer++;
					}
				}
			}
		}
		
		for (int i = 0; i < 2; i++) {
			if (y + dy[i] >= 1 && y +dy[i] <= 8) {
				for (int j = 2; j < 4; j++) {
					if (x + dx[j] >= 1 && x + dx[j] <= 8) {
						answer++;
					}
				}
			}
		}
		
		System.out.println(answer);
	}
}