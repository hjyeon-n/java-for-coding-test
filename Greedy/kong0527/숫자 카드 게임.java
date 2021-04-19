import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        int answer = -1;

        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                // 이 행에서 최솟값을 구하기 위한 변수
                min = Math.min(min, Integer.parseInt(st[j]));
            }
            // 구해진 최솟값 중에서 가장 큰 수를 찾아 answer 값 갱신
            answer = Math.max(answer, min);
        }

        System.out.println(answer);
    }
}
