// PGS - 181945
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181945

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<input.length(); i++) {
            sb.append(input.charAt(i)).append("\n");
        }
        System.out.println(sb);
    }
}
