// BOJ - 34978
// Problem Sheet - https://acmicpc.net/problem/34978

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Character, Set<Character>> rules = new HashMap<>();
        StringTokenizer st;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            char x = st.nextToken().charAt(0);
            int m = Integer.parseInt(st.nextToken());
            Set<Character> set = new HashSet<>();
            while (m-- > 0) {
                set.add(st.nextToken().charAt(0));
            }
            rules.put(x, set);
        }
        String s = br.readLine();
        boolean isValid = true;
        for (int i=0; i<s.length()-1; i++) {
            if (!rules.containsKey(s.charAt(i))) continue;
            if (!rules.get(s.charAt(i)).contains(s.charAt(i + 1))) {
                isValid = false;
                break;
            }
        }
        System.out.println(isValid ? "yes" : "no");
        br.close();
    }
}
