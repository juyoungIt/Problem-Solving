// BOJ - 27866
// Problem Sheet - https://www.acmicpc.net/problem/27866

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        char[] letters = bf.readLine().toCharArray();
        int index = Integer.parseInt(bf.readLine()) - 1;

        System.out.println(letters[index]);

        bf.close();
        System.exit(0);
    }
}