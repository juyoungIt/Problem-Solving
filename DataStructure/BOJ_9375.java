// BOJ - 9375
// Problem Sheet - https://www.acmicpc.net/problem/9375

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int tcSize = Integer.parseInt(bf.readLine()); // 테스트 케이스의 크기
        for(int i=0 ; i<tcSize ; i++) {
            int result = 1; // 의상을 입는 방법의 수
            Map<String, List<String>> costumes = new HashMap<>();
            int n = Integer.parseInt(bf.readLine()); // 의상의 수
            for(int j=0 ; j<n ; j++) {
                String[] costume = bf.readLine().split(" ");
                if(costumes.containsKey(costume[1])) {
                    costumes.get(costume[1]).add(costume[0]);
                } else {
                    costumes.put(costume[1], new ArrayList<>());
                    costumes.get(costume[1]).add(costume[0]);
                }
            }
            for(Map.Entry<String, List<String>> entry : costumes.entrySet()) {
                result *= (entry.getValue().size()+1);
            }
            System.out.println(result-1);
        }

        bf.close();
        System.exit(0);
    }
}