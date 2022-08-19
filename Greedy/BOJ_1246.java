// BOJ - 1246
// Problem Sheet - https://www.acmicpc.net/problem/1246

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()); // 달걀의 수
        int m = Integer.parseInt(st.nextToken()); // 고객의 수
        int[] p = new int[m]; // 각 고객이 제시한 달걀의 가격 저장
        for(int i=0 ; i<m ; i++)
            p[i] = Integer.parseInt(bf.readLine());
        int max = 0, maxIdx = 0; // 최댓값, 최댓값의 인덱스

        // 제시 가격을 크기순으로 정렬
        Arrays.sort(p);

        for(int i=0 ; i<m ; i++) {
            int tmp = (p.length-i >= n) ? n * p[i] : (p.length-i) * p[i];
            if(max < tmp) {
                max = tmp;
                maxIdx = i;
            }
        }

        System.out.println(p[maxIdx] + " " + max);

        bf.close();
        System.exit(0);
    }
}