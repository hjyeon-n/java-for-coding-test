import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(br.readLine());
        int[] dongbin = new int[size];
        String st[] = br.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            dongbin[i] = Integer.parseInt(st[i]);
        }
        Arrays.sort(dongbin);

        size = Integer.parseInt(br.readLine());
        st = br.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            if (binarySearch(Integer.parseInt(st[i]), dongbin, 0, dongbin.length-1) == -1) {
                sb.append("no ");
            }
            else {
                sb.append("yes ");
            }
        }

        System.out.println(sb.toString());
    }

    public static int binarySearch(int key, int[] list, int first, int last) {
        int middle;

        while (first <= last) {
            middle = (first + last) / 2;
            if (key == list[middle]) {
                return middle;
            }
            else if (key > list[middle]) {
                first = middle + 1;
            }
            else {
                last = middle - 1;
            }
        }
        return -1;
    }
}
