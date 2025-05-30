// BOJ - 17029
// Problem Sheet - https://www.acmicpc.net/problem/17029

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Set<String>> properties = new ArrayList<>(n);
        for (int i=0 ; i<n ; i++) {
            String[] row = br.readLine().split(" ");
            int k = Integer.parseInt(row[1]);
            properties.add(new HashSet<>());
            for (int j=2 ; j<k+2 ; j++) {
                properties.get(i).add(row[j]);
            }
        }
        int maxCommonCount = 0;
        for (int i=0 ; i<n ; i++) {
            for (int j=i+1 ; j<n ; j++) {
                Set<String> commonProperties = new HashSet<>(properties.get(i));
                commonProperties.retainAll(properties.get(j));
                maxCommonCount = Math.max(maxCommonCount, commonProperties.size());
            }
        }
        System.out.println(maxCommonCount + 1);
        br.close();
    }
}