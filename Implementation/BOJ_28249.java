// BOJ - 28249
// Problem Sheet - https://www.acmicpc.net/problem/28249

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> peppers = new HashMap<>();
        peppers.put("Poblano", 1_500);
        peppers.put("Mirasol", 6_000);
        peppers.put("Serrano", 15_500);
        peppers.put("Cayenne", 40_000);
        peppers.put("Thai", 75_000);
        peppers.put("Habanero", 125_000);
        int n = Integer.parseInt(br.readLine());
        int sum = 0; 
        for (int i=0 ; i<n ; i++) {
            String name = br.readLine();
            sum += peppers.get(name);
        }
        System.out.println(sum);
        br.close();
    }
}
