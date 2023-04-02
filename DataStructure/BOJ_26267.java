// BOJ - 26267
// Problem Sheet - https://www.acmicpc.net/problem/26267

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Long> caseMapper = new HashMap<>();
        StringTokenizer st;

        int numberOfBanks = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfBanks ; i++) {
            st = new StringTokenizer(bf.readLine());
            int index = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
            if(caseMapper.containsKey(index)) {
                caseMapper.put(index, caseMapper.get(index) + Long.parseLong(st.nextToken()));
            } else {
                caseMapper.put(index, Long.parseLong(st.nextToken()));
            }
        }

        pQueue.addAll(caseMapper.values());
        System.out.println(pQueue.poll());

        bf.close();
        System.exit(0);
    }
}