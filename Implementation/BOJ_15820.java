// BOJ - 15820
// Problem Sheet - https://www.acmicpc.net/problem/15820

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s1 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());
        boolean passSample = true;
        boolean passSystem = true;
        for (int i=0 ; i<s1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            if (a1 != a2) passSample = false;
        }
        for (int i=0 ; i<s2 ; i++) {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            if (a1 != a2) passSystem = false;
        }
        if (passSample && passSystem) {
            System.out.println("Accepted");
        } else if (passSample) {
            System.out.println("Why Wrong!!!");
        } else {
            System.out.println("Wrong Answer");
        }
        br.close();
    }
}
