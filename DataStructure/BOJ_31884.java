// BOJ - 31884
// Problem Sheet - https://www.acmicpc.net/problem/31884

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int q = Integer.parseInt(br.readLine());
        Map<Integer, Integer> yMapper = new HashMap<>();
        for (int i=0 ; i<q ; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if (c == 1) {
                int maxValue = getMaxValueFromMap(yMapper, x);
                for (int j=0 ; j<4 ; j++) {
                    yMapper.put(x + j, maxValue + 1);
                }
            } else if (c == 2) {
                yMapper.put(x, yMapper.getOrDefault(x, 0) + 4);
            } else {
                sb.append(yMapper.getOrDefault(x, 0)).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static int getMaxValueFromMap(Map<Integer, Integer> map, int start) {
        int maxValue = 0;
        for (int i=start ; i<start+4 ; i++) {
            if (map.getOrDefault(i, 0) > maxValue) {
                maxValue = map.getOrDefault(i, 0);
            }
        }
        return maxValue;
    }
}