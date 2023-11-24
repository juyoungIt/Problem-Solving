// BOJ - 8974
// Problem Sheet - https://www.acmicpc.net/problem/8974

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[1_000];
        int curIdx = 0;
        int curVal = 1;
        while(true) {
            for(int i=0 ; i<curVal ; i++) {
                if(curIdx >= 1_000) break;
                arr[curIdx++] = curVal;
            }
            if(curIdx >= 1_000) break;
            curVal++;
        }

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int answer = 0;
        for(int i=a ; i<=b ; i++) {
            answer += arr[i-1];
        }

        System.out.println(answer);

        br.close();
        System.exit(0);
    }
}