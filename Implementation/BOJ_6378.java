// BOJ - 6378
// Problem Sheet - https://www.acmicpc.net/problem/6378

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String n = br.readLine();
            if (n.equals("0")) break;
            int sum = 0;
            do {
                sum = 0;
                for (int i=0 ; i<n.length() ; i++) {
                    sum += n.charAt(i) - '0';
                }
                n = Integer.toString(sum);
            } while (sum / 10 > 0);
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
