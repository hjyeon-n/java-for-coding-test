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
        int count = Integer.parseInt(st[1]);
        int[] A = new int[size];
        Integer[] B = new Integer[size];
        int answer = 0;

        st = br.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            A[i] = Integer.parseInt(st[i]);
        }

        st = br.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            B[i] = Integer.parseInt(st[i]);
        }

        // A 배열은 오름차순으로 정렬
        Arrays.sort(A);

        // B 배열은 내림차순으로 정렬
        Arrays.sort(B, Collections.reverseOrder());

        // B의 값과 A의 값을 서로 바꿈
        for (int i = 0; i < count; i++) {
            if (A[i] > B[i]) {
                break;
            }
            A[i] = B[i];
        }

        for (int num : A) {
            answer += num;
        }

        System.out.println(answer);
    }
}
