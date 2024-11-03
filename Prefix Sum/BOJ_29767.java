// BOJ - 29767
// Problem Sheet - https://www.acmicpc.net/problem/29767

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] acc = new long[N];
        st = new StringTokenizer(br.readLine());
        acc[0] = Integer.parseInt(st.nextToken());
        for (int i=1 ; i<N ; i++) {
            acc[i] = (acc[i - 1] + Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(acc);

        long answer = 0;
        for (int i=N-1 ; i>=N-K ; i--) {
            answer += acc[i];
        }
        System.out.println(answer);

        br.close();
    }
}