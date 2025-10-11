// BOJ - 11189
// Problem Sheet - https://www.acmicpc.net/problem/11189

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        char prev = input.charAt(0);
        int[] switchCounts = new int[3];
        // 1. 나갈 때 항상 시트를 올려둔다
        for (int i=1 ; i<input.length() ; i++) {
            char cur = input.charAt(i);
            if (prev != cur) switchCounts[0]++;
            if (cur != 'U') {
                switchCounts[0]++;
                cur = 'U';
            }
            prev = cur;
        }
        // 2. 나갈 때 항상 시트를 내려둔다
        prev = input.charAt(0);
        for (int i=1 ; i<input.length() ; i++) {
            char cur = input.charAt(i);
            if (prev != cur) switchCounts[1]++;
            if (cur != 'D') {
                switchCounts[1]++;
                cur = 'D';
            }
            prev = cur;
        }
        // 3. 나갈 때 항상 자신이 원하는 상태로 시트를 둔다
        prev = input.charAt(0);
        for (int i=1 ; i<input.length() ; i++) {
            char cur = input.charAt(i);
            if (prev != cur) switchCounts[2]++;
            prev = cur;
        }

        for (int switchCount : switchCounts) {
            sb.append(switchCount).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
