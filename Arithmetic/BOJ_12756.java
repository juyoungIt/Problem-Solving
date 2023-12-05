// BOJ - 12756
// Problem Sheet - https://www.acmicpc.net/problem/12756

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int attackA = Integer.parseInt(st.nextToken());
        int lifeA = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int attackB = Integer.parseInt(st.nextToken());
        int lifeB = Integer.parseInt(st.nextToken());

        while(lifeA > 0 && lifeB > 0) {
            lifeA -= attackB;
            lifeB -= attackA;
        }

        if(lifeA <= 0 && lifeB <= 0) System.out.println("DRAW");
        else if(lifeB <= 0) System.out.println("PLAYER A");
        else System.out.println("PLAYER B");

        br.close();
        System.exit(0);
    }
}