// BOJ - 13144
// Problem Sheet - https://www.acmicpc.net/problem/13144

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] sequence = new int[N];
        boolean[] visit = new boolean[100001];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<N ; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int nextIndex = 0;
        long uniqueSubsequenceCount = 0;
        for(int i=0 ; i<N ; i++) {
            while(nextIndex < N) {
                if (visit[sequence[nextIndex]]) {
                    break;
                }
                visit[sequence[nextIndex++]] = true;
            }
            uniqueSubsequenceCount += (nextIndex - i);
            visit[sequence[i]] = false;
        }

        System.out.println(uniqueSubsequenceCount);

        bf.close();
        System.exit(0);
    }
}