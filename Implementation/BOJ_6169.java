// BOJ - 6169
// Problem Sheet - https://www.acmicpc.net/problem/6169

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        Map<Character, Integer> costMap = new HashMap<>();
        costMap.put('u', u);
        costMap.put('f', f);
        costMap.put('d', d);
        char[] route = new char[t];
        for (int i=0 ; i<t ; i++) {
            route[i] = br.readLine().charAt(0);
        }
        br.close();
        int curCost = 0;
        int count = 0;
        for (int i=0 ; i<t ; i++) {
            char opposite = route[i] != 'f' ? route[i] == 'u' ? 'd' : 'u' : 'f';
            if (curCost + costMap.get(route[i]) + costMap.get(opposite) > m) {
                System.out.println(count);
                return;
            }
            curCost += costMap.get(route[i]);
            curCost += costMap.get(opposite);
            count++;
        }
        System.out.println(count);
    }
}
