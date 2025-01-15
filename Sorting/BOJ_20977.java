// BOJ - 20977
// Problem Sheet - https://www.acmicpc.net/problem/20977

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static String S;

    public static void main(String[] args) throws IOException {
        getInput();
        System.out.println(solve());
    }

    private static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = br.readLine();
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(S.split(""))
                .map(l -> l.charAt(0))
                .sorted(Comparator.comparingInt(Main::getPriority))
                .forEach(sb::append);
        return sb.toString();
    }

    private static int getPriority(char letter) {
        if (letter == 'J') return 0;
        else if (letter == 'O') return 1;
        else if (letter == 'I') return 2;
        else throw new IllegalStateException("invalid letters...");
    }

}