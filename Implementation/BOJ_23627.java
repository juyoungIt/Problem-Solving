// BOJ - 23627
// Problem Sheet - https://www.acmicpc.net/problem/23627

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean isValid = true;
        if (s.length() < 5) {
            isValid = false;
        } else {
            String part = s.substring(s.length() - 5);
            if (!(part.equals("driip"))) {
                isValid = false;
            }
        }
        System.out.println(isValid ? "cute" : "not cute");
        br.close();
    }
}
