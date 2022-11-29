// BOJ - 10816
// Problem Sheet - https://www.acmicpc.net/problem/10816

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> countMapper = new HashMap<>(); // 각 수별로 저장된 수를 유지하는 map
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine()); // 상근이가 가진 카드의 수
        int[] cards = new int[n]; // 상근이가 가진 카드들
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            if(!countMapper.containsKey(cards[i])) countMapper.put(cards[i], 1);
            else countMapper.put(cards[i], countMapper.get(cards[i]) + 1);
        }

        int m = Integer.parseInt(bf.readLine()); // 상근이가 알아보고자 하는 카드의 수
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<m ; i++) {
            int target = Integer.parseInt(st.nextToken());
            if(countMapper.containsKey(target))
                sb.append(countMapper.get(target)).append(" ");
            else
                sb.append(0).append(" ");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}