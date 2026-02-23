// BOJ - 33810
// Problem Sheet - https://www.acmicpc.net/problem/33810

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String origin = "SciComLove";
        int count = 0;
        for (int i=0 ; i<10 ; i++) {
            if (s.charAt(i) != origin.charAt(i)) {
                count++;
            }
        }
        System.out.println(count);
        br.close();
    }
}
