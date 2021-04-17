import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String location = br.readLine();
        // 입력받은 좌표를 int 배열 상에 나타낼 수 있는 좌표로 변환
        int x = location.charAt(1) - '0' - 1;
        int y = location.charAt(0) - 97;
        int count = 0;

        // 이동할 수 있는 범위를 표현
        int dx[] = {2, 2, 1, -1, -2, -2, 1, -2};
        int dy[] = {1, -1, 2, 2, 1, -1, -2, -2};

        for (int i = 0; i < 8; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];

            // 이동할 범위가 체스판을 벗어나면 continue;
            if (x1 < 0 || y1 < 0 || x1 > 7 || y1 > 7) {
                continue;
            }

            // 아니라면 count를 1 증가시킨다.
            count++;
        }

        System.out.println(count);
    }
}
