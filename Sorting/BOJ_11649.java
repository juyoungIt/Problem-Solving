// BOJ - 11649
// Problem Sheet - https://www.acmicpc.net/problem/11649

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder printBuffer = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>(n);
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String reversedWord = sb.append(br.readLine()).reverse().toString();
            words.add(reversedWord);
            sb.setLength(0);
        }
        Collections.sort(words);

        words.forEach(word -> printBuffer.append(word).append("\n"));
        System.out.println(printBuffer);
        br.close();
    }
}