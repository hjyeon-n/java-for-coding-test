import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		소요 시간 : 10분
//		체감 난이도 : 실버 5
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		N 입력 받기
		int N = Integer.parseInt(br.readLine());
		
//		완전 탐색으로 3 포함 여부 확인
		int answer = 0;
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j < 60; j++) {
				for (int k = 0; k < 60; k++) {
//					일의 자리 수에 3이 포함되어 있을 때
					if (i % 10 == 3 || j % 10 == 3 || k % 10 == 3) {
						answer++;
					}
//					십의 자리 수에 3이 포함되어 있을 때
					else if (j / 10 == 3 || k / 10 == 3) {
						answer++;
					}
				}
			}
		}
		
		System.out.println(answer);
	}
}