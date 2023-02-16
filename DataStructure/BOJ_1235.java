// BOJ - 1235
// Problem Sheet - https://www.acmicpc.net/problem/1235

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int studentSize = Integer.parseInt(bf.readLine());
        List<String> studentNumbers = new ArrayList<>(studentSize);
        Set<String> tokens = new HashSet<>();
        for(int i=0 ; i<studentSize ; i++) {
            studentNumbers.add(bf.readLine());
        }

        int studentNumberLength = studentNumbers.get(0).length();
        for(int i=1 ; i<=studentNumberLength ; i++) {
            for(String studentNumber : studentNumbers) {
                String token = studentNumber.substring(studentNumberLength-i);
                if(tokens.contains(token)) {
                    break;
                }
                tokens.add(token);
            }
            if(tokens.size() == studentSize) {
                System.out.println(i);
                break;
            }
            tokens.clear();
        }

        bf.close();
        System.exit(0);
    }
}