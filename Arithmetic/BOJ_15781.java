// BOJ - 15781
// Problem Sheet - https://www.acmicpc.net/problem/15781

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] helmets = new int[N];
        int[] vests = new int[M];

        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<N ; i++) {
            helmets[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<M ; i++) {
            vests[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(helmets);
        Arrays.sort(vests);

        System.out.println(helmets[N-1] + vests[M-1]);

        bf.close();
        System.exit(0);
    }
}