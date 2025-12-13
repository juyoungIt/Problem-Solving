// BOJ - 2490
// Problem Sheet - https://www.acmicpc.net/problem/2490

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i=0 ; i<3 ; i++) {
            st = new StringTokenizer(br.readLine());
            int count = 0;
            for (int j=0 ; j<4 ; j++) {
                int status = Integer.parseInt(st.nextToken());
                if (status == 1) count++;
            }
            if (count == 0) sb.append("D");
            else if (count == 1) sb.append("C");
            else if (count == 2) sb.append("B");
            else if (count == 3) sb.append("A");
            else sb.append("E");
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
