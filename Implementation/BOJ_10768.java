// BOJ - 10768
// Problem Sheet - https://www.acmicpc.net/problem/10768

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        if (m == 2 && d == 18) System.out.println("Special");
        else if (m > 2 || m == 2 && d > 18) System.out.println("After");
        else System.out.println("Before");
        br.close();
    }
}
