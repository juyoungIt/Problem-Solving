// BOJ - 30684
// Problem Sheet - https://www.acmicpc.net/problem/30684

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String> candidates = new ArrayList<>();
        for (int i=0 ; i<N ; i++) {
            String name = br.readLine();
            if (name.length() == 3) {
                candidates.add(name);
            }
        }
        Collections.sort(candidates);

        System.out.println(candidates.get(0));

        br.close();
    }
}