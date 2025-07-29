// BOJ - 1380
// Problem Sheet - https://www.acmicpc.net/problem/1380

import java.util.*;
import java.io.*;

public class Main {

    static final String FORMAT = "%d %s";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int scenario = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            String[] students = new String[n + 1];
            for (int j=1 ; j<=n ; j++) {
                students[j] = br.readLine();
            }
            Set<Integer> confiscated = new HashSet<>();
            for (int j=0 ; j<2*n-1 ; j++) {
                String[] row = br.readLine().split(" ");
                int sid = Integer.parseInt(row[0]);
                if (confiscated.contains(sid)) confiscated.remove(sid);
                else confiscated.add(Integer.parseInt(row[0]));
            }
            int result = confiscated.stream().findFirst().get();
            sb.append(String.format(FORMAT, scenario++, students[result])).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}