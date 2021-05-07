import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 50분
		//		체감 난이도 : 골드 4
		//		★★★★★

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		int[] rslt = new int[N + 1];
		graph = new ArrayList<ArrayList<Integer>>();
		int[] indegree = new int[N + 1];
		
		for (int i = 1; i <= N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int w = Integer.parseInt(st.nextToken());
			arr[i] = w;
			
			while (st.hasMoreElements()) {
				int num = Integer.parseInt(st.nextToken());
				
				if (num == -1) {
					break;
				}
				
				indegree[i] += 1;
				graph.get(num).add(i);
			}
			
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		for (int i = 1; i <= N; i++) {
            rslt[i] = arr[i];
        }
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 0; i < graph.get(now).size(); i++) {
				int idx = graph.get(now).get(i);
				indegree[idx] -= 1;
				rslt[idx] = Math.max(rslt[idx], rslt[now] + arr[idx]);
				if (indegree[idx] == 0) {
					queue.add(idx);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= N; i++) {
			sb.append(rslt[i] + "\n");
		}
		
		System.out.println(sb.toString());
	}	
}