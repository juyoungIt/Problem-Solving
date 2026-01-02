// BOJ - 25641
// Problem Sheet - https://www.acmicpc.net/problem/25641

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        br.close();
        int[] count = new int[2];
        for (int i=0 ; i<n ; i++) {
            if (s.charAt(i) == 's') count[0]++;
            else count[1]++;
        }
        int startIndex = 0;
        for (int i=0 ; i<n ; i++) {
            if (count[0] == count[1]) {
                startIndex = i;
                break;
            }
            char c = s.charAt(i);
            if (c == 's') count[0]--;
            else count[1]--;
        }
        System.out.println(s.substring(startIndex));
    }
}
