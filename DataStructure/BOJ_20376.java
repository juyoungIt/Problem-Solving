// BOJ - 20376
// Problem Sheet - https://www.acmicpc.net/problem/20376

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> placeSet = new HashSet<>();
        while (true) {
            String input = br.readLine();
            if (input == null) break;
            String place = input.substring(11);
            placeSet.add(place);
        }

        System.out.println(placeSet.size());

        br.close();
        System.exit(0);
    }
}