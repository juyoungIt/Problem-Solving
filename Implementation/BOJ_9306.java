// BOJ - 9306
// Problem Sheet - https://www.acmicpc.net/problem/9306

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=n ; i++) {
            String firstName = br.readLine();
            String lastName = br.readLine();
            sb.append(String.format("Case %d: %s, %s\n", i, lastName, firstName));
        }
        System.out.println(sb);
        br.close();
    }
}
