// BOJ - 26742
// Problem Sheet - https://www.acmicpc.net/problem/26742

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] counts = new int[2];
        for (int i=0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            if (c == 'B') counts[0]++;
            else counts[1]++;
        }
        System.out.println(counts[0] / 2 + counts[1] / 2);
        br.close();
    }
}