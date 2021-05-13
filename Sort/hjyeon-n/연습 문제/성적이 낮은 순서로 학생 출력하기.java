import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		소요 시간 : 7분
//		체감 난이도 : 실버3
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Student[] students = new Student[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			int score = Integer.parseInt(st.nextToken());
			
			students[i] = new Student(name, score);
		}
		
		Arrays.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				
				if (o1.score > o2.score) {
					return 1;
				}
				else if (o1.score < o2.score){
					return -1;
				}
				return 0;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (Student s : students) {
			sb.append(s.name + " ");
		}
		
		System.out.println(sb.toString());
	}
}

class Student {
	String name;
	int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
}