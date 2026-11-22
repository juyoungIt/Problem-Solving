// BOJ - 3711
// Problem Sheet - https://acmicpc.net/problem/3711

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int g = Integer.parseInt(br.readLine());
            int[] sn = new int[g];
            for (int i=0; i<g; i++) {
                sn[i] = Integer.parseInt(br.readLine());
            }
            Set<Integer> rmdSet = new HashSet<>();
            for (int m=1; m<100_000; m++) {
                boolean isUnique = true;
                rmdSet.clear();
                for (int i=0; i<g; i++) {
                    int rmd = sn[i] % m;
                    if (rmdSet.contains(rmd)) {
                        isUnique = false;
                        break;
                    }
                    rmdSet.add(rmd);
                }
                if (isUnique) {
                    sb.append(m).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}
