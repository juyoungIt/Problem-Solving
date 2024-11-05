// BOJ - 27386
// Problem Sheet - https://www.acmicpc.net/problem/27386

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] strA = br.readLine().toCharArray();
        char[] strB = br.readLine().toCharArray();
        int mergeSize = strA.length + strB.length;
        char[] merged = new char[mergeSize];
        System.arraycopy(strA, 0, merged, 0, strA.length);
        System.arraycopy(strB, 0, merged, strA.length, strB.length);
        Arrays.sort(merged);
        sb.append(merged);

        System.out.println(sb);
        br.close();
    }
}