import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//		소요 시간 : 50분
		//		체감 난이도 : 실버 2
		
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		int[] answer = solution(5, stages);
		
		for (int i : answer) {
			System.out.print(i + " ");
		}
	}
	
	public static int[] solution(int N, int[] stages) {
        int[] arr = new int[N + 1];
        int len = stages.length;
        
        for (int i = 0; i < len; i++) {
            if (stages[i] > N) {
                continue;
            }
            arr[stages[i]] += 1;
        }
        
        ArrayList<Node> list = new ArrayList<Node>();
        for (int i = 1; i <= N; i++) {
            double val = (double)arr[i] / len;
            len -= arr[i];
            list.add(new Node(i, val));
        }
        
        Collections.sort(list, new Comparator<Node>() {
           @Override
            public int compare(Node o1, Node o2) {
                if (o1.val < o2.val) {
                    return 1;
                }
                else if (o1.val > o2.val) {
                    return -1;
                }
                else {
                    return o1.stage - o2.stage;
                }
            }
        });
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).stage;
        }
        
        return answer;
    }
}

class Node {
    int stage;
    double val;
    
    public Node (int stage, double val) {
        this.stage = stage;
        this.val = val;
    }
}