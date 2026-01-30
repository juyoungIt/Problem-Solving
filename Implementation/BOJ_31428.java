// BOJ - 31428
// Problem Sheet - https://www.acmicpc.net/problem/31428

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] friends = br.readLine().split(" ");
        char elice = br.readLine().charAt(0);
        int count = 0;
        for (String friend : friends) {
            if (friend.charAt(0) == elice) {
                count++;
            }
        }
        System.out.println(count);
        br.close();
    }
}
