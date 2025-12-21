// BOJ - 31994
// Problem Sheet - https://www.acmicpc.net/problem/31994

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int maxCount = 0;
        String answer = "";
        for (int i=0 ; i<7 ; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int count = Integer.parseInt(st.nextToken());
            if (count > maxCount) {
                maxCount = count;
                answer = name;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
