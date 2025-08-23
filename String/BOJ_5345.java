// BOJ - 5345
// Problem Sheet - https://www.acmicpc.net/problem/5345

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String input = br.readLine();
            sb.append(getPLUCount(input)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int getPLUCount(String s) {
        char[] plu = { 'p', 'l', 'u' };
        int count = 0;
        Set<Character> set = new HashSet<>();
        int curIndex = 0;
        for (int i=0 ; i<s.length() ; i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if (c != 'p' && c != 'l' && c != 'u') continue;
            if (set.contains(c)) continue;
            if (c == plu[curIndex]) {
                set.add(c);
                if (set.size() == plu.length) {
                    count++;
                    set.clear();
                }
                curIndex = (curIndex + 1) % plu.length;
            } else {
                curIndex = 0;
                set.clear();
            }
        }
        return count;
    }
}