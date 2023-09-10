// BOJ - 1350
// Problem Sheet - https://www.acmicpc.net/problem/1350

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        String[] files = bf.readLine().split(" ");
        int clusterSize = Integer.parseInt(bf.readLine());
        long clusterCount = Arrays.stream(files)
                .mapToLong(Long::parseLong)
                .map(file -> {
                    long count = file / clusterSize;
                    count = (file % clusterSize > 0) ? count + 1 : count;
                    return count;
                }).sum();

        System.out.println(clusterSize * clusterCount);

        bf.close();
        System.exit(0);
    }
}