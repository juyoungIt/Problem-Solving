// BOJ - 14909
// Problem Sheet - https://www.acmicpc.net/problem/14909

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = (int) Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .filter(e -> e > 0)
                .count();
        System.out.println(answer);
        br.close();
    }
}
