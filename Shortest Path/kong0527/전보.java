import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int map[][];
    static int d[];
    static boolean visited[];
    static int N;
    static ArrayList<Node>[] map2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);
        int C = Integer.parseInt(st[2]);
        map = new int[N+1][N+1];
        map2 = new ArrayList[N+1];
        d = new int[N+1];
        visited = new boolean[N+1];
        int count = 0;
        int ans = 0;

        for (int i = 1; i <= N; i++) {
            map2[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = br.readLine().split(" ");
            int x = Integer.parseInt(st[0]);
            int y = Integer.parseInt(st[1]);
            int z = Integer.parseInt(st[2]);
            map[x][y] = z;
            map2[x].add(new Node(y, z));
        }

        Arrays.fill(d, Integer.MAX_VALUE);

        dijkstra1(C);
        for (int i = 1; i < d.length; i++) {
            if (d[i] != Integer.MAX_VALUE && d[i] != 0) {
                count++;
                ans = Math.max(ans, d[i]);
            }
        }

        System.out.println(count + " " + ans);


        d = new int[N+1];
        visited = new boolean[N+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        count = 0;
        ans = 0;
        dijkstra2(C);
        for (int i = 1; i < d.length; i++) {
            if (d[i] != Integer.MAX_VALUE && d[i] != 0) {
                count++;
                ans = Math.max(ans, d[i]);
            }
        }
        System.out.println(count + " " + ans);
    }

    // 배열을 이용한 풀이법
    public static void dijkstra1(int C) {
        d[C] = 0;

        for(int i = 0; i < N-1; i++){
            int min = Integer.MAX_VALUE;
            int min_index = -1;

            //최소값 찾기
            for(int j = 1; j < N+1; j++){
                if(!visited[j] && d[j] != Integer.MAX_VALUE){
                    if(d[j] < min){
                        min = d[j];
                        min_index = j;
                    }
                }
            }

            visited[min_index] = true;
            for(int j = 1; j < N+1; j++){
                if(!visited[j] && map[min_index][j] != 0){
                    if(d[j] > d[min_index] + map[min_index][j]){
                        d[j] = d[min_index] + map[min_index][j];
                    }
                }
            }
        }
    }

    // 힙을 이용한 풀이법
    public static void dijkstra2(int C) {
        d[C] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(C, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int curr = node.index;
            int distance = node.distance;

            if (visited[curr]) {
                continue;
            }

            visited[curr] = true;

            for (Node next : map2[curr]) {
                if (d[curr] + next.distance < d[next.index]) {
                    d[next.index] = d[curr] + next.distance;
                    pq.add(new Node(next.index, d[next.index]));
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    int index;
    int distance;

    public Node (int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo (Node o) {
        if (this.distance < o.distance) {
            return -1;
        }
        return 1;
    }
}

