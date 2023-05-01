// BOJ - 10798
// Problem Sheet - https://www.acmicpc.net/problem/10798

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<String> words = new ArrayList<>(5);
        int maxLength = 0;
        for(int i=0 ; i<5 ; i++) {
            words.add(bf.readLine());
            if(maxLength < words.get(i).length()) {
                maxLength = words.get(i).length();
            }
        }

        for(int i=0 ; i<maxLength ; i++) {
            for(int j=0 ; j<5 ; j++) {
                if(i >= words.get(j).length()) {
                    continue;
                }
                sb.append(words.get(j).charAt(i));
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}