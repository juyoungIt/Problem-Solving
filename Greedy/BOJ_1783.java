// BOJ - 1783
// Problem Sheet - https://www.acmicpc.net/problem/1783

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()); // 체스판 세로길이
        int m = Integer.parseInt(st.nextToken()); // 체스판 가로길이
        int answer = 0;

        if(n == 1)
            answer = 1;
        else if(n == 2)
            answer = 1 + (((m-1)/2 >= 3) ? 3 : (m-1)/2);
        else if(m < 7)
            answer = (m >= 4) ? 4 : m;
        else
            answer = m-2; // (m-7+5)

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}