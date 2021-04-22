import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        m = Integer.parseInt(st[1]);
        arr = new int[n][m];
        visited = new boolean[n][m];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 방문한 적이 없고 구멍이 뚫려있는 부분이면 dfs 시작
                if (!visited[i][j] && arr[i][j] == 0) {
                    dfs(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int x, int y) {
        // 현재 위치를 방문했다고 표시
        visited[x][y] = true;

        // 사방향으로 갈 수 있는 곳을 모두 탐색
        for (int i = 0; i < 4; i++) {
            int bx = x + dx[i];
            int by = y + dy[i];

            if (bx >= 0 && by >= 0 && bx < n && by < m) {
                // 구멍이 뚫린 곳이고 아직 방문하지 않은 곳이면 다시 dfs
                if (arr[bx][by] == 0 && !visited[bx][by]) {
                    dfs(bx, by);
                }
            }
        }
    }
}
