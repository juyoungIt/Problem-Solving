// BOJ - 10824
// Problem Sheet - https://www.acmicpc.net/problem/10824

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = bf.readLine().split(" ");

        long numberA = Long.parseLong(numbers[0] + numbers[1]);
        long numberB = Long.parseLong(numbers[2] + numbers[3]);

        System.out.println(numberA + numberB);

        bf.close();
        System.exit(0);
    }
}