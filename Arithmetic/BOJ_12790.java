// BOJ - 12790
// Problem Sheet - https://www.acmicpc.net/problem/12790

import java.util .*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<T ; i++) {
            String[] inputs = bf.readLine().split(" ");
            int hp = Math.max(Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[4]), 1);
            int mp = Math.max(Integer.parseInt(inputs[1]) + Integer.parseInt(inputs[5]), 1);
            int attack = Math.max(Integer.parseInt(inputs[2]) + Integer.parseInt(inputs[6]), 0);
            int defence = Integer.parseInt(inputs[3]) + Integer.parseInt(inputs[7]);
            sb.append(hp + 5 * mp + 2 * attack + 2 * defence).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}