// BOJ - 28453
// Problem Sheet - https://www.acmicpc.net/problem/28453

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int level = Integer.parseInt(st.nextToken());
            sb.append(getSection(level)).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

    private static int getSection(int level) {
        if (level == 300) return 1;
        else if (275 <= level && level < 300) return 2;
        else if (250 <= level && level < 275) return 3;
        else return 4;
    }
}
