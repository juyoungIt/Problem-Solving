// BOJ - 25932
// Problem Sheet - https://www.acmicpc.net/problem/25932

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (n-- > 0) {
            boolean isZack = false, isMack = false;
            st = new StringTokenizer(br.readLine());
            for (int i=0 ; i<10 ; i++) {
                int code = Integer.parseInt(st.nextToken());
                if (code == 17) isZack = true;
                if (code == 18) isMack = true;
                sb.append(code).append(" ");
            }
            sb.append("\n");
            if (isZack && isMack) sb.append("both");
            else if (isZack) sb.append("zack");
            else if (isMack) sb.append("mack");
            else sb.append("none");
            sb.append("\n\n");
        }
        System.out.println(sb);
        br.close();
    }
}
