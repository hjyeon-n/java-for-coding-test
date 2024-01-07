import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int size = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        int k = Integer.parseInt(st[2]);
        int answer = 0;
        Integer[] arr = new Integer[size];
        st = br.readLine().split(" ");

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }

        // 배열을 내림차순으로 정리
        Arrays.sort(arr, Collections.reverseOrder());
        // 제일 큰 숫자를 k번 더하고 두 번째 큰 수를 더하는 cycle 횟수
        int mod = m / (k + 1);

        for (int i = 0; i < mod; i++) {
            answer += arr[0] * k;
            answer += arr[1];
        }

        // mod만큼 위 로직을 반복 후 남은 횟수만큼 제일 큰 수를 더한다.
        answer += (m - (k+1) * mod) * arr[0];

        System.out.println(answer);
    }
        // ver. 2022
        // 배열을 오름차순으로 정렬
        Arrays.sort(arr);

        // 한 번으로 도는 세트의 합을 구함
        int nums = k * arr[n-1] + arr[n-2];
        // 한 번의 세트가 돌 수 있는 횟수만큼 구함
        answer += m / (k + 1) * nums;
        // 나머지 만큼 더 더함
        answer += m % (k + 1) * arr[n-1];

        System.out.println(answer);


}
