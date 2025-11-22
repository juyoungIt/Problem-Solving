// BOJ - 24883
// Problem Sheet - https://www.acmicpc.net/problem/24883

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char c = br.readLine().charAt(0);
        if (c == 'N' || c == 'n') System.out.println("Naver D2");
        else System.out.println("Naver Whale");
        br.close();
    }
}
