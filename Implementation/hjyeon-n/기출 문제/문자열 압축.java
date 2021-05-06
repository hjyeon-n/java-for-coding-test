import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("aabbaccc"));
	}

	public static int solution(String s) {
		int answer = s.length();
		ArrayList<String> list = new ArrayList<String>();

		//         자르기 단위
		for (int i = 1; i <= s.length() / 2; i++) {
			//             문자열 자르기
			list = divide(s, i);

			//             문자열 압축
			int len = comp(list);
			answer = Math.min(answer, len);
		}

		return answer;
	}

	public static ArrayList<String> divide(String s, int d) {
		ArrayList<String> list = new ArrayList<String>();
		int i = 0;
		while (i < s.length()) {
			String tmp = "";
			for (int j = 0; j < d; j++) {
				if (i < s.length()) {
					tmp += s.charAt(i++);
				}
				else {
					break;
				}
			}
			list.add(tmp);
		}
		return list;
	}

	public static int comp(ArrayList<String> list) {
		String str = "";
		String tmp = list.get(0);
		int cnt = 1;

		for (int i = 1; i < list.size(); i++) {
			if (tmp.equals(list.get(i))) {
				cnt++;
			}
			else {
				if (cnt > 1) {
					str += String.valueOf(cnt);
				}
				str += tmp;
				cnt = 1;
			}
			tmp = list.get(i);
		}

		if (cnt > 1) {
			str += String.valueOf(cnt);
		}
		str += tmp;

		return str.length();
	}
}
