// BOJ - 33571
// Problem Sheet - https://www.acmicpc.net/problem/33571

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] hcu = new int[26]; // uppercase
        int[] hcl = new int[26]; // lowercase
        hcu['A'-'A'] = 1; 
        hcu['B'-'A'] = 2; 
        hcu['D'-'A'] = 1; 
        hcu['O'-'A'] = 1; 
        hcu['P'-'A'] = 1;
        hcu['Q'-'A'] = 1;
        hcu['R'-'A'] = 1;

        hcl['a'-'a'] = 1;
        hcl['b'-'a'] = 1;
        hcl['d'-'a'] = 1;
        hcl['e'-'a'] = 1;
        hcl['g'-'a'] = 1;
        hcl['o'-'a'] = 1;
        hcl['p'-'a'] = 1;
        hcl['q'-'a'] = 1;
        String input = br.readLine();
        br.close();
        int count = 0;
        for (int i=0 ; i<input.length() ; i++) {
            char c = input.charAt(i);
            if (c == ' ') continue;
            else if (c == '@') count++;
            else if (Character.isLowerCase(c)) {
                count += hcl[c - 'a'];
            } else {
                count += hcu[c - 'A'];
            }
        }
        System.out.println(count);
    }
}
