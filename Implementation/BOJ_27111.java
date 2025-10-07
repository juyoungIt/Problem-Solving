// BOJ - 27111
// Problem Sheet - https://www.acmicpc.net/problem/27111

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Set<Integer> entered = new HashSet<>();
        int omittedCount = 0;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (b == 1) {
                if (entered.contains(a)) {
                    omittedCount++;
                }
                entered.add(a);
            } else {
                if (!entered.contains(a)) {
                    omittedCount++;
                }
                entered.remove(a);
            }
        }
        omittedCount += entered.size();
        System.out.println(omittedCount);
        br.close();
    }
}
