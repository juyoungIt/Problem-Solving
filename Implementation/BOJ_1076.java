// BOJ - 1076
// Problem Sheet - https://www.acmicpc.net/problem/1076

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, int[]> valuePairMap = new HashMap<>();
        valuePairMap.put("black", new int[]{0, 1});
        valuePairMap.put("brown", new int[]{1, 10});
        valuePairMap.put("red", new int[]{2, 100});
        valuePairMap.put("orange", new int[]{3, 1_000});
        valuePairMap.put("yellow", new int[]{4, 10_000});
        valuePairMap.put("green", new int[]{5, 100_000});
        valuePairMap.put("blue", new int[]{6, 1_000_000});
        valuePairMap.put("violet", new int[]{7, 10_000_000});
        valuePairMap.put("grey", new int[]{8, 100_000_000});
        valuePairMap.put("white", new int[]{9, 1_000_000_000});

        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();

        System.out.println(
                ((long) valuePairMap.get(first)[0] * 10 + valuePairMap.get(second)[0])
                        * valuePairMap.get(third)[1]);
        br.close();
    }
}
