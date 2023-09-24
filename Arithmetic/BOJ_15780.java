// BOJ - 15780
// Problem Sheet - https://www.acmicpc.net/problem/15780

import java.util .*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int maxCapacity = 0;
        for(int i=0 ; i<K ; i++) {
            int capacity = Integer.parseInt(st.nextToken());
            maxCapacity += (capacity / 2) + capacity % 2;
        }

        System.out.println(N <= maxCapacity ? "YES" : "NO");

        bf.close();
        System.exit(0);
    }
}