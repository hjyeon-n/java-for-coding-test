import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i <= num; i++) {
            for (int j = 0; j <= 59; j++) {
                for (int k = 0; k <= 59; k++) {
                    // 시각, 분, 초 중 3이 포함되어 있을 때만 수를 센다.
                    if (String.valueOf(i).contains("3") || String.valueOf(j).contains("3")
                            || String.valueOf(k).contains("3")) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
