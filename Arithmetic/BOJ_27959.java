// BOJ - 27959
// Problem Sheet - https://www.acmicpc.net/problem/27959

import java.util.*;
import java.io.*;

public class Main {

    enum Message {
        Yes, No
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        System.out.println(100 * N >= M ? Message.Yes : Message.No);

        bf.close();
        System.exit(0);
    }
}