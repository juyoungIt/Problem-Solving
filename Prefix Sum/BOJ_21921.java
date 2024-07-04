// BOJ - 21921
// Problem Sheet - https://www.acmicpc.net/problem/21921

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] acc = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i=1 ; i<=n ; i++) {
            acc[i] = acc[i - 1] + Integer.parseInt(st.nextToken());
        }

        int maxVisitor = 0;
        int dupleCount = 0;
        for (int i=x ; i<=n ; i++) {
            int visitor = acc[i] - acc[i - x];
            if (maxVisitor == visitor) {
                dupleCount++;
            }
            if (maxVisitor < visitor) {
                maxVisitor = visitor;
                dupleCount = 1;
            }
        }

        if (maxVisitor == 0) {
            System.out.println("SAD");
        } else {
            System.out.printf("%d\n%d\n", maxVisitor, dupleCount);
        }

        br.close();
        System.exit(0);
    }
}