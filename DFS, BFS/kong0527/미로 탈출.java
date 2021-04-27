import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n;
    static int m;
    static int[][] arr;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        m = Integer.parseInt(st[1]);
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(arr[n-1][m-1]);
    }

    public static void bfs(int x, int y) {
        Queue<Location> queue = new LinkedList<>();
        Location loc;
        queue.add(new Location(x, y));

        while (!queue.isEmpty()) {
            loc = queue.poll();

            for (int i = 0; i < 4; i++) {
                int bx = loc.x + dx[i];
                int by = loc.y + dy[i];

                if (bx >= 0 && by >= 0 && bx < n && by < m) {
                    if (arr[bx][by] == 1) {
                        arr[bx][by] = arr[loc.x][loc.y] + 1;
                        queue.add(new Location(bx, by));
                    }
                }
            }

        }
    }
}

class Location {
    int x, y;
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
