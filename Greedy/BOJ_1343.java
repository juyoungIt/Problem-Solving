// BOJ - 1343
// Problem Sheet - https://www.acmicpc.net/problem/1343

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 출력 결과를 저장
        String input = bf.readLine();
        int partLen = 0;

        // 문자열에 대한 탐색을 진행
        for(int i=0 ; i<input.length() ; i++) {
            if(input.charAt(i) != '.' && i < input.length()-1) {
                partLen++;
                continue;
            }
            if(i == input.length()-1 && input.charAt(i) != '.')
                partLen++;
            if(partLen%2 == 0) {
                for(int j=0 ; j<partLen/4 ; j++)
                    sb.append("AAAA");
                partLen %= 4;
                for(int j=0 ; j<partLen/2 ; j++)
                    sb.append("BB");
            }
            else {
                sb.setLength(0); // StringBuilder를 비움
                sb.append("-1");
                break;
            }
            if(input.charAt(i) == '.')
                sb.append(".");
            partLen = 0; // 재사용을 위해 초기화
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}