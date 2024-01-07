import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int[] arr = new int[n];
        st = br.readLine().split(" ");
        int answer = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            count++;
            if (count >= arr[i]) {
                answer++;
                count = 0;
            }
        }

        System.out.println(answer);

    }
}
