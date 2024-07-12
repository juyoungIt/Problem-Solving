// BOJ - 24431
// Problem Sheet - https://www.acmicpc.net/problem/24431

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            String[] words = new String[n];
            st = new StringTokenizer(br.readLine());
            for (int j=0 ; j<n ; j++) {
                words[j] = st.nextToken();
            }
            sb.append(getSimilarPairCnt(words, l, f)).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static int getSimilarPairCnt(String[] words, int l, int f) {
        int similarPairCnt = 0;
        boolean[] isUsed = new boolean[words.length];
        for (int i=0 ; i<words.length-1 ; i++) {
            for (int j=i+1 ; j<words.length ; j++) {
                if (!isUsed[i] && !isUsed[j] && words[i].endsWith(words[j].substring(l-f))) {
                    isUsed[i] = true;
                    isUsed[j] = true;
                    similarPairCnt++;
                }
            }
        }
        return similarPairCnt;
    }
}