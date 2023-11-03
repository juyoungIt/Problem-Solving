// BOJ - 28113
// Problem Sheet - https://www.acmicpc.net/problem/28113

import java.util.*;
import java.io.*;

public class Main {

    enum VEHICLE {
        Bus, Subway, Anything
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(b < n) {
            System.out.println(VEHICLE.Bus);
        } else if(a == b) {
            System.out.println(VEHICLE.Anything);
        } else if(a < b) {
            System.out.println(VEHICLE.Bus);
        } else {
            System.out.println(VEHICLE.Subway);
        }

        bf.close();
        System.exit(0);
    }
}