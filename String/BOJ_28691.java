// BOJ - 28691
// Problem Sheet - https://www.acmicpc.net/problem/28691

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] clubs = { "MatKor", "WiCys", "CyKor", "AlKor", "$clear" };
        char firstLetter = br.readLine().charAt(0);
        for (String club : clubs) {
            if (club.charAt(0) != firstLetter) continue;
            System.out.println(club);
        }
        br.close();
    }
}