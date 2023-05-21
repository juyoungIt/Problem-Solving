// BOJ - 2789
// Problem Sheet - https://www.acmicpc.net/problem/2789

import java.util.*;
import java.io.*;

public class Main {

    private static final List<Character> filter = List.of('C', 'A', 'M', 'B', 'R', 'I', 'D', 'G', 'E');

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(char letter : bf.readLine().toCharArray()) {
            if(!filter.contains(letter)) {
                sb.append(letter);
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}