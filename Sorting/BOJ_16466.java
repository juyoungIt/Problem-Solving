// BOJ - 16466
// Problem Sheet - https://www.acmicpc.net/problem/16466

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] tickets = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++) {
            tickets[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tickets);

        int lastMin = 1;
        for (int i=0 ; i<n ; i++) {
            if (tickets[i] <= lastMin) {
                lastMin = tickets[i] + 1;
            } else {
                break;
            }
        }

        System.out.println(lastMin);
        br.close();
    }
}