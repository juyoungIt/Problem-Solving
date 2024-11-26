// BOJ - 6752
// Problem Sheet - https://www.acmicpc.net/problem/6752

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int[] chores = new int[C];
        for (int i=0 ; i<C ; i++) {
            chores[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(chores);

        int answer = 0;
        for (int i=0 ; i<C ; i++) {
            if (T - chores[i] < 0) break;
            T -= chores[i];
            answer++;
        }

        System.out.println(answer);
        br.close();
    }
}