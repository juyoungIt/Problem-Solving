// BOJ - 10826
// Problem Sheet - https://www.acmicpc.net/problem/10826

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tcSize = Integer.parseInt(bf.readLine()); // 테스트케이스의 수

        for(int i=0 ; i<tcSize ; i++) {
            String[] numbers = bf.readLine().split(",");
            System.out.println(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]));
        }

        bf.close();
        System.exit(0);
    }
}