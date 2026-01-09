// BOJ - 30402
// Problem Sheet - https://www.acmicpc.net/problem/30402

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 15; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 15; j++) {
                char p = st.nextToken().charAt(0);
                if (p == 'w') {
                    System.out.println("chunbae");
                    return;
                } else if (p == 'b') {
                    System.out.println("nabi");
                    return;
                } else if (p == 'g') {
                    System.out.println("yeongcheol");
                    return;
                } else {
                    continue;
                }
            }
        }
        br.close();
    }
}
