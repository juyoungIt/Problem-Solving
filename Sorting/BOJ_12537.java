// BOJ - 12537
// Problem Sheet - https://www.acmicpc.net/problem/12537

import java.util.*;
import java.io.*;

public class Main {

    static String OUTPUT_FORMAT = "Case #%d: %d\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=n ; i++) {
            int s = Integer.parseInt(br.readLine());
            String[] ropes = br.readLine().split(" ");
            List<Integer> red = new LinkedList<>();
            List<Integer> blue = new LinkedList<>();
            for (int j=0 ; j<s ; j++) {
                int length = Integer.parseInt(ropes[j].substring(0, ropes[j].length() - 1));
                char color = ropes[j].charAt(ropes[j].length() - 1);
                if (color == 'R') red.add(length);
                else blue.add(length);
            }
            red.sort(Collections.reverseOrder());
            blue.sort(Collections.reverseOrder());
            int maxLength = 0;
            while (!red.isEmpty() && !blue.isEmpty()) {
                int r = red.remove(0);
                int b = blue.remove(0);
                maxLength += r + b - 2;
            }
            sb.append(String.format(OUTPUT_FORMAT, i, maxLength));
        }

        System.out.println(sb);
        br.close();
    }
}