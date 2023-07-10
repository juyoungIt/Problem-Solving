// BOJ - 13422
// Problem Sheet - https://www.acmicpc.net/problem/13422

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<T ; i++) {
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            int[] accHomes = new int[N+1];
            for(int j=1 ; j<=N ; j++) {
                accHomes[j] = accHomes[j-1] + Integer.parseInt(st.nextToken());
            }
            if(N == M) {
                sb.append(Math.min(1, getPossibleCaseCount(accHomes, N, M, K))).append("\n");
                continue;
            }
            sb.append(getPossibleCaseCount(accHomes, N, M, K)).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static int getPossibleCaseCount(int[] accHomes, int N, int M, int K) {
        int possibleCaseCount = 0;
        int nextIndex = M;
        for(int i=1 ; i<=N ; i++) {
            if(i <= nextIndex) {
                if(accHomes[nextIndex] - accHomes[i-1] < K) {
                    possibleCaseCount++;
                }
            } else {
                if(accHomes[N] - accHomes[i-1] + accHomes[nextIndex] < K) {
                    possibleCaseCount++;
                }
            }
            nextIndex = (++nextIndex % N == 0) ? N : nextIndex % N;
        }
        return possibleCaseCount;
    }
}