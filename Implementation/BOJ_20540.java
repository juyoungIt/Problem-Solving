// BOJ - 20540
// Problem Sheet - https://www.acmicpc.net/problem/20540

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String mbti = br.readLine();
        for (int i=0 ; i<4 ; i++) {
            char c = mbti.charAt(i);
            if (c == 'E') sb.append("I");
            if (c == 'I') sb.append("E");
            if (c == 'S') sb.append("N");
            if (c == 'N') sb.append("S");
            if (c == 'T') sb.append("F");
            if (c == 'F') sb.append("T");
            if (c == 'J') sb.append("P");
            if (c == 'P') sb.append("J");
        }
        System.out.println(sb);
        br.close();
    }
}
