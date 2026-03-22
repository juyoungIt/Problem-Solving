// BOJ - 27310
// Problem Sheet - https://www.acmicpc.net/problem/27310

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int cCount = 0, ubCount = 0;
        for (int i=0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            if (c == '_') ubCount++;
            if (c == ':') cCount++;
        }
        System.out.println(s.length() + cCount + ubCount * 5);
        br.close();
    }
}
