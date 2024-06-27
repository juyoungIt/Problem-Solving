// BOJ - 17559
// Problem Sheet - https://www.acmicpc.net/problem/17559

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] toxicWastes = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<Integer> toxicSet = new HashSet<>();
        for (int toxicWaste : toxicWastes) {
            toxicSet.add(toxicWaste);
        }
        System.out.println(toxicSet.size());

        br.close();
        System.exit(0);
    }
}