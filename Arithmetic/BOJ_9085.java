// BOJ - 9085
// Problem Sheet - https://www.acmicpc.net/problem/9085

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int numberOfTestCases = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfTestCases ; i++) {
            int numberOfnumbers = Integer.parseInt(bf.readLine());
            int sum = 0;
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<numberOfnumbers ; j++) {
                sum += Integer.parseInt(st.nextToken());
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}