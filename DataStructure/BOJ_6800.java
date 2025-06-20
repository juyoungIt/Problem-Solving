// BOJ - 6800
// Problem Sheet - https://www.acmicpc.net/problem/6800

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());
        Map<String, Character> codeMap = new HashMap<>();
        while (k-- > 0) {
            String[] row = br.readLine().split(" ");
            codeMap.put(row[1], row[0].charAt(0));
        }
        String code = br.readLine();

        while (!code.isEmpty()) {
            for (Map.Entry<String, Character> entry : codeMap.entrySet()) {
                if (code.startsWith(entry.getKey())) {
                    sb.append(entry.getValue());
                    code = code.substring(entry.getKey().length());
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}
