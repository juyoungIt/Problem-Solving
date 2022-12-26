// BOJ - 2002
// Problem Sheet - https://www.acmicpc.net/problem/2002

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Map<String, Integer> seqMapper = new HashMap<>(); // 각 차량별 터널에 들어간 순서를 유지하는 map
        List<String> after = new ArrayList<>(n);
        int result = 0; // 터널 내부에서 추월한 것으로 판단되는 차량 수

        for(int seq=1 ; seq<=n ; seq++) {
            String carNumber = bf.readLine();
            seqMapper.put(carNumber, seq);
        }

        for(int i=0 ; i<n ; i++) {
            after.add(bf.readLine());
        }

        for(int seq=0 ; seq<n ; seq++) {
            for(int i=seq+1 ; i<n ; i++) {
                if(seqMapper.get(after.get(seq)) > seqMapper.get(after.get(i))) {
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);

        bf.close();
        System.exit(0);
    }
}