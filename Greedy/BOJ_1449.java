// BOJ - 1449
// Problem Sheet - https://www.acmicpc.net/problem/1449

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] pos = new int[n];    // 물이 세는 곳에 대한 위치정보
        int curPos = 0; // 현재 위치
        int answer = 0;

        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++)
            pos[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(pos);

        curPos = pos[0];
        for(int i=1 ; i<n ; i++) {
            if(pos[i] - curPos >= l) {
                answer++;
                curPos = pos[i];
            }
        }
        answer++;

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}