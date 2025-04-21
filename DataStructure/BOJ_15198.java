// BOJ - 15198
// Problem Sheet - https://www.acmicpc.net/problem/15198

import java.util.*;
import java.io.*;

public class Main {

    private static int k, n;
    private static String[] docs;

	public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        docs = new String[n];
        for (int i=0 ; i<n ; i++) {
            docs[i] = br.readLine();
        }
        br.close();
    }

    private static String solve() {
        List<String> nkd = new LinkedList<>();
        Set<String> docSet = new HashSet<>();
        for (String doc : docs) {
            if (docSet.contains(doc)) {
                String moved = nkd.get(nkd.indexOf(doc));
                nkd.remove(moved);
                nkd.add(0, doc);
            } else {
                docSet.add(doc);
                nkd.add(0, doc);
                if (nkd.size() > k) {
                    String removed = nkd.get(nkd.size() - 1);
                    nkd.remove(nkd.size() - 1);
                    docSet.remove(removed);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String doc : nkd) {
            sb.append(doc).append("\n");
        }
        return sb.toString();
    }

}