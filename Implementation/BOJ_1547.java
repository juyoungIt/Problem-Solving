// BOJ - 1547
// Problem Sheet - https://www.acmicpc.net/problem/1547

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int curNumber = 1;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x == curNumber || y == curNumber) {
                curNumber = (x == curNumber) ? y : x;
            }
        }
        System.out.println(curNumber);
        br.close();
    }
}