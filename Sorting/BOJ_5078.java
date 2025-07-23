// BOJ - 5078
// Problem Sheet - https://www.acmicpc.net/problem/5078

import java.util.*;
import java.io.*;

public class Main {

    static int w, h;
    static String[] wife, husband;
    static Map<Character, Integer> sizeWeight, colorWeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sizeWeight = new HashMap<>();
        sizeWeight.put('S', 1); sizeWeight.put('M', 2); sizeWeight.put('L', 3);
        colorWeight = new HashMap<>();
        colorWeight.put('B', 1); colorWeight.put('K', 2); colorWeight.put('N', 3);
        colorWeight.put('O', 4); colorWeight.put('P', 5); colorWeight.put('R', 6);
        colorWeight.put('W', 7);

        while (true) {
            w = Integer.parseInt(br.readLine());
            if (w == 0) break;
            wife = new String[w];
            for (int i=0 ; i<w ; i++) {
                wife[i] = br.readLine();
            }
            h = Integer.parseInt(br.readLine());
            husband = new String[h];
            for (int i=0 ; i<h ; i++) {
                husband[i] = br.readLine();
            }
            String[] shirts = new String[w + h];
            System.arraycopy(wife, 0, shirts, 0, w);
            System.arraycopy(husband, 0, shirts, w, h);
            Arrays.sort(shirts, (s1, s2) -> {
                int sizeWeight1 = sizeWeight.get(s1.charAt(0));
                int sizeWeight2 = sizeWeight.get(s2.charAt(0));
                if (sizeWeight1 == sizeWeight2) {
                    return colorWeight.get(s1.charAt(1)) - colorWeight.get(s2.charAt(1));
                }
                return sizeWeight1 - sizeWeight2;
            });
            for (String shirt : shirts) {
                sb.append(shirt).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

}