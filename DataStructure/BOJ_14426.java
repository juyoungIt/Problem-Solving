// BOJ - 14426
// Problem Sheet - https://www.acmicpc.net/problem/14426

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int numberOfPrefix = 0;

        int numberOfWords = Integer.parseInt(st.nextToken());
        int numberOfRequests = Integer.parseInt(st.nextToken());
        Set<String> prefixs = new HashSet<>();
        for(int i=0 ; i<numberOfWords ; i++) {
            String word = bf.readLine();
            for(int j=1 ; j<=word.length() ; j++) {
                prefixs.add(word.substring(0, j));
            }
        }

        for(int i=0 ; i<numberOfRequests ; i++) {
            if(prefixs.contains(bf.readLine())) {
                numberOfPrefix++;
            }
        }

        System.out.println(numberOfPrefix);

        bf.close();
        System.exit(0);
    }
}