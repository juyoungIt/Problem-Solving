// BOJ - 5586
// Problem Sheet - https://www.acmicpc.net/problem/5586

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int numberOfJOI = 0;
        int numberOfIOI = 0;

        String input = bf.readLine();
        int currentIndex = 0;
        while(currentIndex+3 <= input.length()) {
            String token = input.substring(currentIndex, currentIndex+3);
            if(token.equals("JOI")) {
                numberOfJOI++;
            } else if(token.equals("IOI")) {
                numberOfIOI++;
            }
            currentIndex++;
        }

        System.out.println(numberOfJOI);
        System.out.println(numberOfIOI);

        bf.close();
        System.exit(0);
    }
}