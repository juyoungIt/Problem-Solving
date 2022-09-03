// BOJ - 12904
// Problem Sheet - https://www.acmicpc.net/problem/12904

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder(bf.readLine());  // 시작하는 문자열
        StringBuilder t = new StringBuilder(bf.readLine());  // 목표

        while(s.length() < t.length()) {
            if(t.charAt(t.length()-1) == 'A') t.delete(t.length()-1, t.length());
            else t.delete(t.length()-1, t.length()).reverse();
        }

        if(s.toString().equals(t.toString())) System.out.println(1);
        else System.out.println(0);

        bf.close();
        System.exit(0);
    }
}