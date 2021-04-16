import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		�ҿ� �ð� : 8��
//		ü�� ���̵� : ����� 2
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		N �Է� �ޱ�
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = 1;
		int y = 1;
		
//		�̵� ��ȹ ���̸�ŭ ��ɾ� Ȯ��
		while (st.hasMoreElements()) {
			String command = st.nextToken();
			
//			���� Ȯ�� �� �̵�
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