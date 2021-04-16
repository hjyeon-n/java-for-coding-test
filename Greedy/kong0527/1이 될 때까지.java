import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int target = Integer.parseInt(st[0]);
        int num = Integer.parseInt(st[1]);
        int answer = 0;

        while (target > 1) {
            if (target % num == 0) {
                target /= num;
            }

            else {
                target--;
            }
            answer++;
        }

        System.out.println(answer);
    }

    // 이 코드처럼 하면 수가 100억이 넘어갈 때에도 빠르게 동작할 수 있다.
    public static void bookAnswer(int n, int k) {
        int result = 0;

        while (true) {
            // N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
            int target = (n / k) * k;
            result += (n - target);
            n = target;
            // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
            if (n < k) break;
            // K로 나누기
            result += 1;
            n /= k;
        }

        // 마지막으로 남은 수에 대하여 1씩 빼기
        result += (n - 1);
        System.out.println(result);
    }
}
