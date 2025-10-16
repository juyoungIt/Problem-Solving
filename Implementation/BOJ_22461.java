// BOJ - 22461
// Problem Sheet - https://www.acmicpc.net/problem/22461

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int convertCount = 0;
            Set<Integer> generated = new HashSet<>();
            generated.add(n);
            while (n / 10 > 0) {
                n = getMaxSliceProduct(n);
                if (generated.contains(n)) {
                    convertCount = -1;
                    break;
                }
                generated.add(n);
                convertCount++;
            }
            sb.append(convertCount).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int getMaxSliceProduct(int n) {
        int maxSliceProduct = 0;
        String nStr = Integer.toString(n);
        for (int i=1 ; i<nStr.length() ; i++) {
            int partA = Integer.parseInt(nStr.substring(0, i));
            int partB = Integer.parseInt(nStr.substring(i));
            maxSliceProduct = Math.max(maxSliceProduct, partA * partB);
        }
        return maxSliceProduct;
    }
}