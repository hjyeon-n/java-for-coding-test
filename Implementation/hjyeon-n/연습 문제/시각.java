import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		�ҿ� �ð� : 10��
//		ü�� ���̵� : �ǹ� 5
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		N �Է� �ޱ�
		int N = Integer.parseInt(br.readLine());
		
//		���� Ž������ 3 ���� ���� Ȯ��
		int answer = 0;
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j < 60; j++) {
				for (int k = 0; k < 60; k++) {
//					���� �ڸ� ���� 3�� ���ԵǾ� ���� ��
					if (i % 10 == 3 || j % 10 == 3 || k % 10 == 3) {
						answer++;
					}
//					���� �ڸ� ���� 3�� ���ԵǾ� ���� ��
					else if (j / 10 == 3 || k / 10 == 3) {
						answer++;
					}
				}
			}
		}
		
		System.out.println(answer);
	}
}