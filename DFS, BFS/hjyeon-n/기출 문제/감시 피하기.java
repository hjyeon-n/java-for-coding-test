import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static String[][] map, copy;
	static boolean[][] visited;
	static boolean[] picked;
	static ArrayList<int[]> rslt;
	static ArrayList<Location> list, teacher;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 47분
		//		체감 난이도 : 골드5
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new String[N][N];
		copy = new String[N][N];
		visited = new boolean[N][N];
		list = new ArrayList<Location>();
		teacher = new ArrayList<Location>();
		rslt = new ArrayList<int[]>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken();
				
				if (map[i][j].equals("X")) {
					list.add(new Location(i, j));
				}
				
				if (map[i][j].equals("T")) {
					teacher.add(new Location(i, j));
				}
			}
		}
		
		arr = new int[3];
		picked = new boolean[list.size()];
		comb(list.size(), 0, 0);
		String answer = "NO";
		
		for (int i = 0; i < rslt.size(); i++) {
			int[] tmp = rslt.get(i);
			deepcopy();
			for (int j = 0; j < 3; j++) {
				Location loc = list.get(tmp[j]);
				copy[loc.x][loc.y] = "O";
			}
			
			if (traversal()) {
				answer = "YES";
				break;
			}
		}
		
		System.out.println(answer);
	}
	
	public static boolean traversal() {
		for (int i = 0; i < teacher.size(); i++) {
			Location loc = teacher.get(i);
			int x = loc.x;
			int y = loc.y;
			
			while (x >= 0) {
				if (copy[x][y].equals("O")) {
					break;
				}
				
				if (copy[x][y].equals("S")) {
					return false;
				}
				
				x--;
			}
			
			x = loc.x;
			
			while (x < N) {
				if (copy[x][y].equals("O")) {
					break;
				}
				
				if (copy[x][y].equals("S")) {
					return false;
				}
				
				x++;
			}
			
			x = loc.x;
			
			while (y >= 0) {
				if (copy[x][y].equals("O")) {
					break;
				}
				
				if (copy[x][y].equals("S")) {
					return false;
				}
				
				y--;
			}
			
			y = loc.y;
			
			while (y < N) {
				if (copy[x][y].equals("O")) {
					break;
				}
				
				if (copy[x][y].equals("S")) {
					return false;
				}
				
				y++;
			}
		}
		return true;
	}
	
	public static void comb(int all, int depth, int idx) {
		if (depth == 3) {
			int[] newArr = new int[3];
			for (int i = 0; i < 3; i++) {
				newArr[i] = arr[i];
			}
			rslt.add(newArr);
			return;
		}
		
		for (int i = idx; i < all; i++) {
			if (!picked[i]) {
				picked[i] = true;
				arr[depth] = i;
				comb(all, depth + 1, i);
				picked[i] = false;
			}
		}
	}
	
	public static void deepcopy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = map[i][j];
				visited[i][j] = false;
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