import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		�ҿ� �ð� : 12��
//		ü�� ���̵� : �ǹ�4
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String loc = br.readLine();
		
//		x�� y�� �Է�
		int y = loc.charAt(0) - 97;
		int x = Integer.parseInt(loc.substring(1));
		
//		����Ʈ �̵� ���� ��ǥ
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