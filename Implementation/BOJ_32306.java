// BOJ - 32306
// Problem Sheet - https://www.acmicpc.net/problem/32306

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] scores = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1 ; i<=3 ; i++) {
            scores[0] += Integer.parseInt(st.nextToken()) * i;
        }
        st = new StringTokenizer(br.readLine());
        for (int i=1 ; i<=3 ; i++) {
            scores[1] += Integer.parseInt(st.nextToken()) * i;
        }
        if (scores[0] == scores[1]) System.out.println(0);
        else if (scores[0] < scores[1]) System.out.println(2);
        else System.out.println(1);
        br.close();
    }
}
