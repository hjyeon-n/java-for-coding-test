import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 백준 14503 로봇청소기와 동일한 문제 ! !
public class Main {
    static int arr[][];
    static int rX;
    static int rY;
    static int rD;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        // 캐릭터가 지나다닐 NxM 크기의 배열
        arr = new int[Integer.parseInt(st[0])][Integer.parseInt(st[1])];
        st = br.readLine().split(" ");
        rX = Integer.parseInt(st[0]);   // 캐릭터의 A 좌표
        rY = Integer.parseInt(st[1]);   // 캐릭터의 B 좌표
        rD = Integer.parseInt(st[2]);   // 캐릭터가 바라보는 방향

        for (int i = 0; i < arr.length; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(solve());
    }

    public static int solve() {
        Queue<Location> queue = new LinkedList<Location>();
        int count = 1;
        queue.add(new Location(rX, rY, rD));

        while (!queue.isEmpty()) {
            Location loc = queue.poll();
            int x = loc.x;
            int y = loc.y;
            int d = loc.d;
            // 사방향이 모두 막혀있는지를 판단할 변수
            boolean flag = false;
            // 청소를 한 곳은 -1로 표시
            arr[x][y] = -1;

            // 사방향이 모두 막혀있거나 이미 가본 곳인지 판단
            if (arr[x][y-1] != 0 && arr[x][y+1] != 0 && arr[x-1][y] != 0 && arr[x+1][y] != 0){
                flag = true;
            }

            // 현재 바라보는 방향이 북쪽
            if (d == 0) {
                // 사방향이 모두 막혀있거나 방문한 경우
                if (flag){
                    // 후진도 할 수 없는 경우 작동을 멈춤
                    if (arr[x+1][y] == 1) {
                        break;
                    }
                    // 후진을 할 수 있으면 후진
                    else {
                        queue.add(new Location(x+1, y, d));
                    }
                }

                else {
                    // 왼쪽 방향으로 이동할 수 있는 경우 이동
                    if (arr[x][y-1] == 0) {
                        queue.add(new Location(x, y-1, 3));
                        count++;
                    }
                    // 왼쪽방향으로 이동할 수 없으면 현재 위치에서 방향만 바꾼다
                    else {
                        queue.add(new Location(x, y, 3));
                    }
                }
            }   // 이 이후에는 모두 동일한 로직이므로 주석 생략

            else if (d == 1) {
                if (flag){
                    if (arr[x][y-1] == 1) {
                        break;
                    }
                    else {
                        queue.add(new Location(x, y-1, d));
                    }
                }

                else {
                    if (arr[x-1][y] == 0) {
                        queue.add(new Location(x-1, y, 0));
                        count++;
                    } else {
                        queue.add(new Location(x, y, 0));
                    }
                }
            }

            else if (d == 2) {
                if (flag){
                    if (arr[x-1][y] == 1) {
                        break;
                    }
                    else {
                        queue.add(new Location(x-1, y, d));
                    }
                }

                else {
                    if (arr[x][y+1] == 0) {
                        queue.add(new Location(x, y+1, 1));
                        count++;
                    } else {
                        queue.add(new Location(x, y, 1));
                    }
                }
            }

            else {
                if (flag){
                    if (arr[x][y+1] == 1) {
                        break;
                    }
                    else {
                        queue.add(new Location(x, y+1, d));
                    }
                }

                else {
                    if (arr[x+1][y] == 0) {
                        queue.add(new Location(x+1, y, 2));
                        count++;
                    } else {
                        queue.add(new Location(x, y, 2));
                    }
                }
            }
        }

        return count;
    }
}

class Location {
    int x, y, d;
    public Location(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}