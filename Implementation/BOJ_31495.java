// BOJ - 31495
// Problem Sheet - https://www.acmicpc.net/problem/31495

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        boolean isValid = true;
        if (input.length() <= 2) {
            isValid = false;
        } else if (!(input.charAt(0) == '"' && input.charAt(input.length()-1) == '"')) {
            isValid = false;
        }
        System.out.println(isValid ? input.substring(1, input.length()-1) : "CE");
        br.close();
    }
}
