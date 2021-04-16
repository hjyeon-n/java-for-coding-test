import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String st[] = br.readLine().split(" ");
        int[][] arr = new int[size+1][size+1];
        int x = 1;
        int y = 1;

        for (int i = 0; i < st.length; i++) {
            if (st[i].equals("L")) {
                if (y - 1 >= 1) {
                    y = y - 1;
                }
            }

            else if (st[i].equals("R")) {
                if (y + 1 <= size) {
                    y = y + 1;
                }
            }

            else if (st[i].equals("U")) {
                if (x - 1 >= 1) {
                    x = x - 1;
                }
            }

            else {
                if (x + 1 <= size) {
                    x = x + 1;
                }
            }
        }

        System.out.println(x + " " + y);
    }
}
