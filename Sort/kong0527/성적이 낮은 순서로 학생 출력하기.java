import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < size; i++) {
            String st[] = br.readLine().split(" ");
            hashMap.put(st[0], Integer.parseInt(st[1]));
        }

        // map을 value 기준으로 내림차순
        List<String> keySetList = new ArrayList<>(hashMap.keySet());
        Collections.sort(keySetList, (o1, o2) -> (hashMap.get(o1).compareTo(hashMap.get(o2))));

        for (String key : keySetList) {
            System.out.print(key + " ");
        }
    }
}
