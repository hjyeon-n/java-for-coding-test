public class Main {
	static String u, v, answer = "";
	public static void main(String[] args){
		// TODO Auto-generated method stub
		//		소요 시간 : 50분
		//		체감 난이도 : 골드5
		
		System.out.println(solution("(()())()"));
	}
	public static String solution(String p) {
        if (p.equals("")) {
            return p;
        }
        
        u = "";
        v = "";
        
        divideStr(p);
        
        if (isFine(u)) {
            return u += solution(v);
        }
        else {
        	return makeStr(u, v);
        }
    }
    
    public static void divideStr(String p) {
        int rt = 0;
        int lt = 0;
        int i;
        for (i = 0; i < p.length(); i++) {
            u += String.valueOf(p.charAt(i));
            if (p.charAt(i) == '(') {
                rt++;
            }
            else {
                lt++;
            }
            if (rt == lt) {
                break;
            }
        }
        
        while (i != p.length() - 1) {
            v += String.valueOf(p.charAt(i + 1));
            i++;
        }
    }
    
    public static boolean isFine(String p) {
        int sum = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
            	sum += 1;
            }
            
            if (p.charAt(i) == ')') {
            	if (sum == 0) {
            		return false;
            	}
                sum -= 1;
            }
        }
        return sum == 0;
    }
    
    public static String reverse(String p) {
        String rslt = "";
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                rslt += ')';
            }
            else {
                rslt += '(';
            }
        }
        return rslt;
    }
    
    public static String makeStr(String u, String v) {    	
        String rslt = "(";
        rslt += solution(v);
        rslt += ")";
        u = u.substring(1, u.length() - 1);
        u = reverse(u);
        rslt += u;
        return rslt;
    }
}