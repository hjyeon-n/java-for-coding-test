import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//		소요 시간 : 40분
		//		체감 난이도 : 실버 3

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Student> list = new ArrayList<Student>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			int Korean = Integer.parseInt(st.nextToken());
			int English = Integer.parseInt(st.nextToken());
			int Math = Integer.parseInt(st.nextToken());
			
			list.add(new Student(name, Korean, English, Math));
		}
		
		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if (o1.Korean != o2.Korean) {
					return Integer.compare(o2.Korean, o1.Korean);
				}
				else {
					if (o1.English != o2.English) {
						return Integer.compare(o1.English, o2.English);
					}
					else {
						if (o1.Math != o2.Math) {
							return Integer.compare(o2.Math, o1.Math);
						}
						else {
							return o1.name.compareTo(o2.name);
						}
					}
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(list.get(i).name + "\n");
		}
		
		System.out.println(sb.toString());
	}
}

class Student {
	String name;
	int Korean;
	int English;
	int Math;
	
	public Student (String name, int Korean, int English, int Math) {
		this.name = name;
		this.Korean = Korean;
		this.English = English;
		this.Math = Math;
	}
}