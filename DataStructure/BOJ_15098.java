// BOJ - 15098
// Problem Sheet - https://www.acmicpc.net/problem/15098

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = bf.readLine().split(" ");
        Set<String> tokenSet = new HashSet<>(List.of(tokens));

        if(tokens.length == tokenSet.size()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        bf.close();
        System.exit(0);
    }
}