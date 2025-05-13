// BOJ - 22232
// Problem Sheet - https://www.acmicpc.net/problem/22232

import java.util.*;
import java.io.*;

public class Main {

    private static int n, m;
    private static String[] files;
    private static Map<String, Integer> extensions;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        n = Integer.parseInt(row[0]);
        m = Integer.parseInt(row[1]);
        files = new String[n];
        for (int i=0 ; i<n ; i++) {
            files[i] = br.readLine();
        }
        extensions = new HashMap<>();
        for (int i=0 ; i<m ; i++) {
            extensions.put(br.readLine(), i);
        }
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(files)
                .sorted((f1, f2) -> {
                    String[] f1Token = f1.split("\\.");
                    String[] f2Token = f2.split("\\.");
                    if (f1Token[0].equals(f2Token[0])) {
                        boolean f1Support = extensions.containsKey(f1Token[1]);
                        boolean f2Support = extensions.containsKey(f2Token[1]);
                        if (f1Support != f2Support) {
                            return f1Support ? -1 : 1;
                        }
                        return f1Token[1].compareTo(f2Token[1]);
                    }
                    return f1Token[0].compareTo(f2Token[0]);
                })
                .forEach(f -> sb.append(f).append("\n"));
        return sb.toString();
    }

}