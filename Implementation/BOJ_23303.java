// BOJ - 23303
// Problem Sheet - https://www.acmicpc.net/problem/23303

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(input.contains("d2") || input.contains("D2") ? "D2" : "unrated");
        br.close();
    }
}
