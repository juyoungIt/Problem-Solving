// BOJ - 16495
// Problem Sheet - https://www.acmicpc.net/problem/16495

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] letters = br.readLine().toCharArray();

        long sequenceIndex = 0;
        for (char letter : letters) {
            sequenceIndex *= 26;
            sequenceIndex += letter - 'A' + 1;
        }

        System.out.println(sequenceIndex);

        br.close();
        System.exit(0);
    }
}