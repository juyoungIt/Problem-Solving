// BOJ - 5929
// Problem Sheet - https://www.acmicpc.net/problem/5929

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String base2Str = br.readLine();
        String base3Str = br.readLine();
        long[] base2 = new long[base2Str.length()];
        long[] base3 = new long[base3Str.length()];
        base2[0] = base3[0] = 1;
        for (int i=1 ; i<base2Str.length() ; i++) base2[i] = base2[i - 1] << 1;
        for (int i=1 ; i<base3Str.length() ; i++) base3[i] = base3[i - 1] * 3;

        long base2Value = Long.parseLong(base2Str, 2);
        long base3Value = Long.parseLong(base3Str, 3);

        Set<Long> candidates = new HashSet<>();
        for (int i=0 ; i<base2Str.length() ; i++) {
            int index = base2Str.length() - 1 - i;
            if (base2Str.charAt(i) == '0') {
                candidates.add(base2Value + base2[index]);
            } else {
                candidates.add(base2Value - base2[index]);
            }
        }

        for (int i=0 ; i<base3Str.length() ; i++) {
            for (int j=0 ; j<3 ; j++) {
                int index = base3Str.length() - 1 - i;
                if (base3Str.charAt(i) - '0' == j) continue;
                long cur = base3Value - (base3Str.charAt(i) - '0') * base3[index] + j * base3[index];
                if (candidates.contains(cur)) {
                    System.out.println(cur);
                    return;
                }
            }
        }

        br.close();
    }
}