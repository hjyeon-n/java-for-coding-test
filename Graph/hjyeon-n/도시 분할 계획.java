import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 22분
		//		체감 난이도 : 골드 5
		//		★★★★★

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1];
		ArrayList<Edge> edges = new ArrayList<Edge>();
		
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(x, y, w));
		}
		
		Collections.sort(edges, new Comparator<Edge> (){
			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				if (o1.w > o2.w) {
					return 1;
				}
				else if (o1.w < o2.w) {
					return -1;
				}
				return 0;
			}
		});
		
		int answer = 0;
		int last = 0;
		for (int i = 0; i < M; i++) {
			Edge edge = edges.get(i);
			int x = edge.x;
			int y = edge.y;
			int w = edge.w;
			
			if (find(x) != find(y)) {
				union(x, y);
				answer += w;
				last = w;
			}
		}
		
		System.out.println(answer - last);
	}
	
	public static int find(int v) {
		if (v == arr[v]) {
			return v;
		}
		
		return v = find(arr[v]);
	}
	
	public static void union(int v1, int v2) {
		v1 = find(v1);
		v2 = find(v2);
		
		if (v1 > v2) {
			arr[v1] = v2;
		}
		else {
			arr[v2] = v1;
		}
	}
}

class Edge {
	int x;
	int y;
	int w;
	
	public Edge(int x, int y, int w) {
		this.x = x;
		this.y = y;
		this.w = w;
	}
}