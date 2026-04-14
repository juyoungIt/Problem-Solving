// BOJ - 23843
// Problem Sheet - https://www.acmicpc.net/problem/23843

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] charge = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++) {
            charge[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(charge);
        PriorityQueue<Integer> accTime = new PriorityQueue<>();
        for (int i=0 ; i<m ; i++) {
            accTime.add(0);
        }
        for (int i=n-1 ; i>=0 ; i--) {
            accTime.add(accTime.poll() + charge[i]);
        }
        for (int i=0 ; i<m-1 ; i++) {
            accTime.poll();
        }
        System.out.println(accTime.poll());
        br.close();
    }
}
