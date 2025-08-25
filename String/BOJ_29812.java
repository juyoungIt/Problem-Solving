// BOJ - 29812
// Problem Sheet - https://www.acmicpc.net/problem/29812

import java.util.*;
import java.io.*;

public class Main {

    static final String ENERGY_ZERO = "Nalmeok";
    static final String HYU_ZERO = "I love HanYang University";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String[] row = br.readLine().split(" ");
        int d = Integer.parseInt(row[0]);
        int m = Integer.parseInt(row[1]);
        int energy = 0, hyuCount = 0;
        int hCount = 0, yCount = 0, uCount = 0;
        int cad = 0, dad = 0; // click-and-delete / drag-and-delete
        for (int i=0 ; i<n ; i++) {
            if (s.charAt(i) == 'H' || s.charAt(i) == 'Y' || s.charAt(i) == 'U') {
                energy += Math.min(cad, dad);
                cad = 0;
                dad = 0;
                if (s.charAt(i) == 'H') hCount++;
                else if (s.charAt(i) == 'Y') yCount++;
                else uCount++;
            } else {
                cad += d;
                dad = m + d;
            }
        }
        energy += Math.min(cad, dad);
        hyuCount = Math.min(hCount, Math.min(yCount, uCount));
        sb.append(energy > 0 ? energy : ENERGY_ZERO)
                .append("\n")
                .append(hyuCount > 0 ? hyuCount : HYU_ZERO);
        System.out.println(sb);
        br.close();
    }

}