// BOJ - 32627
// Problem Sheet - https://www.acmicpc.net/problem/32627

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0. 사용자 입력 수신
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        // 1. 카운트 정보를 갱신
        int[] counts = new int[26];
        for (int i=0 ; i<n ; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        // 2. 회차에 따라 사전 순으로 가장 앞서는 문자를 제거
        for (int i=0 ; i<26 ; i++) {
            if (m == 0) break;
            int tmp = m;
            m -= counts[i];
            counts[i] = m > 0 ? 0 : counts[i] - tmp;
        }
        // 3. 남아있는 문자만 기존 입력에서 재조립하여 다시 출력
        StringBuilder sb = new StringBuilder();
        for (int i=n-1 ; i>=0 ; i--) {
            char c = s.charAt(i);
            if (counts[c - 'a'] == 0) continue;
            counts[c - 'a']--;
            sb.append(c);
        }
        System.out.println(sb.reverse());
        br.close();
    }
}