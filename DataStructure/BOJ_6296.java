// BOJ - 6296
// Problem Sheet - https://www.acmicpc.net/problem/6296

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Set<String> subStrings = new HashSet<>();

        int sizeOfSubstring = Integer.parseInt(st.nextToken());
        int numberOfAlpabets = Integer.parseInt(st.nextToken());
        String inputStr = bf.readLine();
        for(int i=0 ; i<=inputStr.length()-sizeOfSubstring ; i++) {
            subStrings.add(inputStr.substring(i, i+sizeOfSubstring));
        }

        System.out.println(subStrings.size());

        bf.close();
        System.exit(0);
    }
}