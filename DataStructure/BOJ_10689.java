// BOJ - 10689
// Problem Sheet - https://www.acmicpc.net/problem/10689

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    private static final String OUTPUT_FORMAT = "Case %d: %d\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=t ; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] problems = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Set<Integer> totalSet = Arrays.stream(problems).boxed().collect(Collectors.toSet());
            Set<Integer> solvedSet = new HashSet<>();
            for (int j=0 ; j<n ; j++) {
                solvedSet.add(problems[j]);
                if (solvedSet.size() == totalSet.size()) {
                    sb.append(String.format(OUTPUT_FORMAT, i, j + 1));
                    break;
                }
            }
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}