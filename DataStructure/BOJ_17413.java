// BOJ - 17413
// Problem Sheet - https://www.acmicpc.net/problem/17413

import java.io.*;

public class Main {

    private static String S;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        br.close();
    }

    private static String solve() {
        StringBuilder finalBuffer = new StringBuilder();
        StringBuilder reverseBuffer = new StringBuilder();

        boolean isTag = false;
        for (int i=0 ; i<S.length() ; i++) {
            char cur = S.charAt(i);
            if (cur == '<') {
                isTag = true;
                finalBuffer.append(reverseBuffer.reverse());
                reverseBuffer.setLength(0);
                finalBuffer.append(cur);
            } else if (cur == '>') {
                isTag = false;
                finalBuffer.append(cur);
            } else if (cur == ' ') {
                if (isTag) {
                    finalBuffer.append(cur);
                } else {
                    finalBuffer.append(reverseBuffer.reverse());
                    reverseBuffer.setLength(0);
                    finalBuffer.append(cur);
                }
            } else {
                if (isTag) finalBuffer.append(cur);
                else reverseBuffer.append(cur);
            }
        }
        finalBuffer.append(reverseBuffer.reverse());
        return finalBuffer.toString();
    }
}