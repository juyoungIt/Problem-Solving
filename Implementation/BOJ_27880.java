// BOJ - 27880
// Problem Sheet - https://www.acmicpc.net/problem/27880

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int totalHeight = 0;
        for (int i=0 ; i<4 ; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int height = Integer.parseInt(st.nextToken());
            if (s.equals("Es")) totalHeight += height * 21;
            else totalHeight += height * 17;
        }
        System.out.println(totalHeight);
        br.close();
    }
}
