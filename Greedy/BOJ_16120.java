// BOJ - 16120
// Problem Sheet - https://www.acmicpc.net/problem/16120

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = bf.readLine(); // 입력 문자열

        // 문자열을 구성하는 각 문자에 대하여 다음을 반복함
        for(int i=0 ; i<str.length() ; i++) {
            char c = str.charAt(i);
            sb.append(c);
            if(sb.length() >= 4) {
                if(sb.substring(sb.length()-4, sb.length()).equals("PPAP"))
                    sb.delete(sb.length()-3, sb.length());
            }
        }

        // 처리결과를 판단
        if(sb.length() == 1 && sb.toString().equals("P")) System.out.println("PPAP");
        else System.out.println("NP");

        bf.close();
        System.exit(0);
    }
}