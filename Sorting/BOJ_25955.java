// BOJ - 25955
// Problem Sheet - https://www.acmicpc.net/problem/25955

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] origin = br.readLine().split(" ");
        String[] sorted = new String[N];
        Map<Character, Integer> levels = new HashMap<>();
        levels.put('B', 1);
        levels.put('S', 2);
        levels.put('G', 3);
        levels.put('P', 4);
        levels.put('D', 5);
        System.arraycopy(origin, 0, sorted, 0, N);
        Arrays.sort(sorted, (s1, s2) -> {
            if (s1.charAt(0) == s2.charAt(0)) {
                return Integer.parseInt(s2.substring(1))
                        - Integer.parseInt(s1.substring(1));
            }
            return levels.get(s1.charAt(0)) - levels.get(s2.charAt(0));
        });

        if (Arrays.equals(origin, sorted)) {
            System.out.println("OK");
        } else {
            System.out.println("KO");
            for (int i=0 ; i<N ; i++) {
                if (!origin[i].equals(sorted[i])) {
                    System.out.printf("%s %s\n", sorted[i], origin[i]);
                    break;
                }
            }
        }

        br.close();
    }
}