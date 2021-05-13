public class Main {
	static int cnt;
	public static void main(String[] args){
		// TODO Auto-generated method stub
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		System.out.println(solution(key, lock));
	}

	public static boolean solution(int[][] key, int[][] lock) {
        int m = key.length;
        int n = lock.length;
        int[][] map = new int[n * 3][n * 3];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i + n][j + n] = lock[i][j];
            }
        }
        
        for (int t = 0; t < 4; t++) {
            key = rotate(key);
            
            for(int a = 0; a < map.length - m; a++) {
                for(int b = 0; b < map.length - m; b++) {
                    for(int i = 0; i < m; i++) {
                        for(int j = 0; j < m; j++) {
                            map[a + i][b + j] += key[i][j];
                        }
                    }
                    
                    if(isUnlock(map)){
                        return true;
                    } 
                    
                    for(int i = 0; i < m; i++) {
                        for(int j = 0; j < m; j++) {
                            map[a + i][b + j] -= key[i][j];
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static int[][] rotate(int[][] key) {
        int m = key.length;
        int[][] newKey = new int[m][m];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                newKey[i][j] = key[m - 1 - j][i];
            }
        }
        return newKey;
    }
    
    public static boolean isUnlock(int[][] newLock) {
        int cnt = 0;
        int len = newLock.length / 3;
        for(int i = len; i < newLock.length - len; i++) {
            for(int j = len; j < newLock.length - len; j++) {
                if(newLock[i][j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt == len * len;
    }
}