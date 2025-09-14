// BOJ - 5093
// Problem Sheet - https://www.acmicpc.net/problem/5093

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] replacements = { '*', '?', '/', '+', '!' };
        while (true) {
            String s = br.readLine();
            if (s.equals("#")) break;
            Set<Character> charSet = new HashSet<>();
            Map<Character, Character> replaced = new HashMap<>();
            int letterIdx = 0;
            for (int i=0 ; i<s.length() ; i++) {
                char c = s.charAt(i);
                if (charSet.contains(Character.toLowerCase(c))) {
                    if (!replaced.containsKey(Character.toLowerCase(c))) {
                        replaced.put(Character.toLowerCase(c), replacements[letterIdx++]);
                    }
                    sb.append(replaced.get(Character.toLowerCase(c)));
                } else {
                    charSet.add(Character.toLowerCase(c));
                    sb.append(c);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}