// BOJ - 10205
// Problem Sheet - https://www.acmicpc.net/problem/10205

import java.util.*;
import java.io.*;

public class Main {

    private static final String FORMAT = "Data Set %d:\n%d\n\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=k ; i++) {
            int h = Integer.parseInt(br.readLine());
            String s = br.readLine();
            for (int j=0 ; j<s.length() ; j++) {
                char c = s.charAt(j);
                if (c == 'c') h++;
                else h--;
            }
            sb.append(String.format(FORMAT, i, h));
        }
        System.out.print(sb);
        br.close();
    }
}