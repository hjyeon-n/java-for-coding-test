import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        arr = new int[n];
        st = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }
        Arrays.sort(arr);
        System.out.println(binarySearch(m, arr[arr.length-1]));
    }

    public static int binarySearch(int m, int max) {
        int start = 0;
        int end = max;
        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int num = calc(mid);

            if (num < m) {
                end = mid - 1;
            }

            else {
                answer = mid;
                start = mid + 1;
            }
        }
        return answer;
    }

    public static int calc(int height) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i] - height;
            if (n > 0) {
                sum += n;
            }
        }

        return sum;
    }
}
