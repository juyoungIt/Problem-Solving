// BOJ - 15649
// Problem Sheet - https://www.acmicpc.net/problem/15649

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int M;
    private static int[] selected;
    private static boolean[] used;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];
        used = new boolean[N+1];

        generateCase(0);
        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static void generateCase(int index) {
        if(index >= M) {
            Arrays.stream(selected).forEach(element -> sb.append(element).append(" "));
            sb.append("\n");
        } else {
            for(int i=1 ; i<=N ; i++) {
                if(used[i]) {
                    continue;
                }
                selected[index] = i;
                used[i] = true;
                generateCase(index+1);
                used[i] = false;
            }
        }
    }
}