// BOJ - 26558
// Problem Sheet - https://www.acmicpc.net/problem/26558

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int c = Integer.parseInt(br.readLine());
            Deque<String>[] stacks = new ArrayDeque[3];
            for (int i=0 ; i<3 ; i++) {
                stacks[i] = new ArrayDeque<>();
            }
            for (int i=0 ; i<c ; i++) {
                String[] row = br.readLine().split(" ");
                StringBuilder article = new StringBuilder();
                for (int j=0 ; j<row.length-1 ; j++) {
                    if (j == 0) article.append(row[j]);
                    else article.append(" ").append(row[j]);
                }
                String type = row[row.length - 1].substring(1, row[row.length - 1].length() - 1);
                stacks[type.equals("shirt") ? 0 : (type.equals("pants") ? 1 : 2)].push(article.toString());
            }

            while (!stacks[0].isEmpty() && !stacks[1].isEmpty() && !stacks[2].isEmpty()) {
                StringJoiner sj = new StringJoiner(", ");
                for (int i=0 ; i<3 ; i++) {
                    sj.add(stacks[i].pop());
                }
                sb.append(sj).append("\n");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}