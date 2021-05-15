import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    // 책 제공 코드 참고. 나중에 다시 풀기!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");

        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        int[] dp = new int[m+1];
        int[] won = new int[n];

        for (int i = 0; i < n; i++) {
            won[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dp, 10001);

        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = won[i]; j <= m; j++) {
                if (dp[j - won[i]] != 10001) {
                    dp[j] = Math.min(dp[j], dp[j - won[i]] + 1);
                }
            }
        }


        if (dp[m] == 10001) {
            System.out.println(-1);
        }
        else {
            System.out.println(dp[m]);
        }

    }
}
