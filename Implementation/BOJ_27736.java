// BOJ - 27736
// Problem Sheet - https://www.acmicpc.net/problem/27736

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] votes = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++) {
            votes[Integer.parseInt(st.nextToken()) + 1]++;
        }
        if (votes[1] >= ((double) n) / 2) {
            System.out.println("INVALID");
        } else if (votes[0] >= votes[2]) {
            System.out.println("REJECTED");
        } else {
            System.out.println("APPROVED");
        }
        br.close();
    }
}
