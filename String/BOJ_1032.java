// BOJ - 1032
// Problem Sheet - https://www.acmicpc.net/problem/1032

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfResults = Integer.parseInt(bf.readLine());
        List<String> results = new ArrayList<>(numberOfResults);
        for(int i=0 ; i<numberOfResults ; i++) {
            results.add(bf.readLine());
        }

        for(int i=0 ; i<results.get(0).length() ; i++) {
            boolean isValid = true;
            char letter = results.get(0).charAt(i);
            for(String result : results) {
                if(letter != result.charAt(i)) {
                    isValid = false;
                    break;
                }
            }
            if(isValid) {
                sb.append(letter);
            } else {
                sb.append("?");
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}