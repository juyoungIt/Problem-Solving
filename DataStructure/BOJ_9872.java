// BOJ - 9872
// Problem Sheet - https://www.acmicpc.net/problem/9872

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> cntMapper = new HashMap<>(); // 빈도수 정보 관리
        PriorityQueue<Integer> cowQueue = new PriorityQueue<>(Collections.reverseOrder()); // 빈도 수 저장

        int n = Integer.parseInt(bf.readLine()); // 소요된 시간 (기록한 수)
        for(int i=0 ; i<n ; i++) {
            String[] cows = bf.readLine().split(" ");
            Arrays.sort(cows); // 사전 순으로 정렬함 - 통일된 순서로 데이터를 다루기 위함
            String key = Arrays.toString(cows);

            if(!cntMapper.containsKey(key)) cntMapper.put(key, 1);
            else cntMapper.put(key, cntMapper.get(key) + 1);
        }

        // 빈도수 정보를 queue에 넣음
        cowQueue.addAll(cntMapper.values());
        System.out.println(cowQueue.poll());

        bf.close();
        System.exit(0);
    }
}