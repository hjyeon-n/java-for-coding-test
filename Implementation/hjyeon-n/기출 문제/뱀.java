import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N, K, time;
	static Queue<Command> queue;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 15분
		//		체감 난이도 : 실버 4

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		time = 0;

		StringTokenizer st;

		map = new int[N + 1][N + 1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			map[x][y] = 2;
		}

		int L = Integer.parseInt(br.readLine());
		queue = new LinkedList<Command>();

		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			String C = st.nextToken();

			queue.add(new Command(X, C));
		}

		move();
	}

	public static void move() {
		Deque<Node> deque = new ArrayDeque<Node>();
		deque.add(new Node(1, 1));
		int cnt = 0;
		String direction = "D";
		int x = 1, y = 1;
		map[1][1] = 1;

		while (true) {
			if (!queue.isEmpty() && cnt == queue.peek().x) {
				String command = queue.poll().c;

				if (direction.equals("D") && command.equals("D")) {
					direction = "B";
				}
				else if (direction.equals("D") && command.equals("L")) {
					direction = "U";
				}
				else if (direction.equals("B") && command.equals("D")) {
					direction = "L";
				}
				else if (direction.equals("B") && command.equals("L")) {
					direction = "D";
				}
				else if (direction.equals("L") && command.equals("D")) {
					direction = "U";
				}
				else if (direction.equals("L") && command.equals("L")) {
					direction = "B";
				}
				else {
					direction = command;
				}
			}

			int nx = x;
			int ny = y;

			if (direction.equals("B")) {
				nx += 1;
			}
			else if (direction.equals("U")) {
				nx -= 1;
			}
			else if (direction.equals("L")) {
				ny -= 1;
			}
			else {
				ny += 1;
			}

			cnt++;

			//			범위 확인
			if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
				//				자기 몸통에 부딪히지 않았는지 확인
				if (map[nx][ny] == 1) {
					break;
				}
				else {
					//					사과 있는 지 확인
					if (map[nx][ny] == 2) {
						map[nx][ny] = 1;
						deque.add(new Node(nx, ny));
					}
					else {
						map[nx][ny] = 1;
						Node node = deque.pollFirst();
						map[node.x][node.y] = 0;
						deque.add(new Node(nx, ny));
					}
				}
				x = nx;
				y = ny;
			}
			else {
				break;
			}
		}

		System.out.println(cnt);
	}
}

class Command {
	int x;
	String c;

	public Command(int x, String c) {
		this.x = x;
		this.c = c;
	}
}

class Node {
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}