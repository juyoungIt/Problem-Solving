// BOJ - 28445
// Problem Sheet - https://www.acmicpc.net/problem/28445

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Set<String> colors = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        colors.addAll(List.of(bf.readLine().split(" ")));
        colors.addAll(List.of(bf.readLine().split(" ")));
        List<String> uniqueColors = new LinkedList<>(colors);
        Collections.sort(uniqueColors);

        for(int i=0 ; i<uniqueColors.size() ; i++) {
            for(int j=0 ; j<uniqueColors.size() ; j++) {
                sb.append(uniqueColors.get(i))
                        .append(" ")
                        .append(uniqueColors.get(j))
                        .append("\n");
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}